
/*
 * Copyright (C) 2011 Archie L. Cobbs. All rights reserved.
 *
 * $Id: AbstractQueryContainer.java 576 2012-11-30 19:06:42Z archie.cobbs $
 */

package org.dellroad.stuff.vaadin;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.AbstractContainer;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * Support superclass for read-only {@link Container} implementations where each {@link Item} in the container
 * is backed by a Java object, and the Java objects are generated via {@linkplain #query a query} that returns
 * a {@link QueryList} containing (some portion of) the backing objects. The container's item ID's are simply
 * the indexes of the corresponding objects in this list.
 *
 * <p>
 * This class will invoke {@link #query} as needed to (re)generate the query list. The query list is then cached.
 * However, if any invocation of {@link QueryList#get} throws an {@link InvalidQueryListException}, then the cached
 * list is discarded and {@link #query} is invoked again to regenerate it. In this way, the {@link QueryList} is
 * allowed to decide on demand when it is invalid or incapable of providing a specific list member. For example,
 * when using JPA, a list may be considered invalid if the current EntityManager session has changed.
 * </p>
 *
 * <p>
 * Note that the {@link QueryList} being invalid is an orthogonal concept from the contents of the list having changed.
 * Invalid means "this list can no longer be used" while changed means "this list contains out-of-date information".
 * Normally, the latter implies the former (but not vice-versa). The list becoming invalid does not in itself not cause
 * any notifications to be sent, so no new query will be performed until e.g. the user interface explicitly requests
 * more information.
 * </p>
 *
 * <p>
 * Therefore, if the list content changes, first invoke {@link #invalidate} to discard the cached {@link QueryList},
 * and then {@link #fireItemSetChange} to notify listeners; for convenience, {@link #reload} will perform these two
 * steps for you.
 * </p>
 *
 * <p>
 * The subclass may forcibly invalidate the current {@link QueryList} via {@link #invalidate}; this merely discards it
 * and will force a new invocation of {@link #query} on the next container access. In many situations, however,
 * the use of {@link #invalidate} is never required.
 * </p>
 *
 * <p>
 * For scalability reasons the {@link QueryList} may actually only contain a portion of the list, throwing
 * {@link InvalidQueryListException}s when other list members are accessed.  An "index hint" parameter provided to
 * {@link #query} indicates which member of the container is of current interest. The returned {@link QueryList}
 * is required to provide exception-free access only to the indicated member, so in the extreme case only a single
 * list member could be kept. In practice, normally range of members near to the index hint would be kept;
 * see for example {@link WindowQueryList}.
 * </p>
 *
 * @param <T> the type of the Java objects that back each {@link Item} in the container
 * @see QueryList
 * @see SimpleQueryList
 * @see WindowQueryList
 */
@SuppressWarnings("serial")
public abstract class AbstractQueryContainer<T> extends AbstractContainer implements Container.Ordered, Container.Indexed,
  Container.PropertySetChangeNotifier, Container.ItemSetChangeNotifier {

    protected QueryList<? extends T> queryList;

    private final HashMap<String, PropertyDef<?>> propertyMap = new HashMap<String, PropertyDef<?>>();
    private PropertyExtractor<? super T> propertyExtractor;

// Constructors

    /**
     * Constructor.
     *
     * <p>
     * After using this constructor, subsequent invocations of {@link #setPropertyExtractor setPropertyExtractor()}
     * and {@link #setProperties setProperties()} are required to define the properties of this container
     * and how to extract them.
     */
    protected AbstractQueryContainer() {
        this(null);
    }

    /**
     * Constructor.
     *
     * <p>
     * After using this constructor, a subsequent invocation of {@link #setProperties setProperties()} is required
     * to define the properties of this container.
     *
     * @param propertyExtractor used to extract properties from the underlying Java objects;
     *  may be null but then container is not usable until one is configured via
     * {@link #setPropertyExtractor setPropertyExtractor()}
     */
    protected AbstractQueryContainer(PropertyExtractor<? super T> propertyExtractor) {
        this(propertyExtractor, null);
    }

    /**
     * Primary constructor.
     *
     * @param propertyExtractor used to extract properties from the underlying Java objects;
     *  may be null but then container is not usable until one is configured via
     * {@link #setPropertyExtractor setPropertyExtractor()}
     * @param propertyDefs container property definitions; null is treated like the empty set
     */
    protected AbstractQueryContainer(PropertyExtractor<? super T> propertyExtractor,
      Collection<? extends PropertyDef<?>> propertyDefs) {
        this.setPropertyExtractor(propertyExtractor);
        this.setProperties(propertyDefs);
    }

// Public methods

    /**
     * Get the configured {@link PropertyExtractor} for this container.
     */
    public PropertyExtractor<? super T> getPropertyExtractor() {
        return this.propertyExtractor;
    }

    /**
     * Change the configured {@link PropertyExtractor} for this container.
     * Invoking this method does not result in any container notifications.
     *
     * @param propertyExtractor used to extract properties from the underlying Java objects;
     *  may be null but the container is not usable without one
     */
    public void setPropertyExtractor(PropertyExtractor<? super T> propertyExtractor) {
        this.propertyExtractor = propertyExtractor;
    }

    /**
     * Change the configured properties of this container.
     *
     * @param propertyDefs container property definitions; null is treated like the empty set
     * @throws IllegalArgumentException if {@code propertyDefs} contains a property with a duplicate name
     */
    public void setProperties(Collection<? extends PropertyDef<?>> propertyDefs) {
        if (propertyDefs == null)
            propertyDefs = Collections.<PropertyDef<?>>emptySet();
        this.propertyMap.clear();
        for (PropertyDef<?> propertyDef : propertyDefs) {
            if (this.propertyMap.put(propertyDef.getName(), propertyDef) != null)
                throw new IllegalArgumentException("duplicate property name `" + propertyDef.getName() + "'");
        }
        this.fireContainerPropertySetChange();
    }

    /**
     * Reload this container.
     *
     * <p>
     * This discards the current cached {@link QueryList} (if any) and fires an item set change event.
     */
    public void reload() {
        this.invalidate();
        this.fireItemSetChange();
    }

// Subclass hooks and methods

    /**
     * Perform a query to (re)generate the list of Java objects backing this container.
     *
     * <p>
     * The particular position in the list we are interested in is given as a hint by the {@code index} parameter.
     * That is, an invocation of <code>{@link QueryList#get}(hint)</code> is likely immediately after this method
     * returns and if so it must complete without throwing an exception.
     * </p>
     *
     * <p>
     * The {@code hint} can be used to implement a highly scalable query list containing external objects
     * (such as from a database) where only a small "window" of objects is actually kept in memory at any one time.
     * Of course, implementations are also free to ignore {@code hint}. However, the returned {@link QueryList}
     * must at least tolerate one invocation of <code>{@link QueryList#get}(hint)</code> without throwing an exception,
     * assuming that {@code hint} does not exceed the size of the list.
     * </p>
     *
     * @param hint index of the list element we are interested in
     * @return list of Java objects backing this container
     */
    protected abstract QueryList<? extends T> query(long hint);

    /**
     * Discard the current cached {@link QueryList}, if any.
     */
    protected void invalidate() {
        this.queryList = null;
    }

    /**
     * Get the Java backing object at the given index in the list.
     *
     * @return backing object, or null if {@code index} is out of range
     */
    protected T getJavaObject(int index) {
        if (index < 0 || index >= this.ensureList(index).size())
            return null;
        try {
            return this.queryList.get(index);
        } catch (InvalidQueryListException e) {
            this.invalidate();
            try {
                return this.ensureList(index).get(index);
            } catch (InvalidQueryListException e2) {
                throw new RuntimeException("query() was given a hint of " + index + " but QueryList.get(" + index + ") failed", e2);
            }
        }
    }

    /**
     * Ensure we have a cached query list.
     *
     * @param hint index of the list element we are interested in, passed to {@link #query} if no query list is cached
     * @return cached query list, never null
     */
    protected QueryList<? extends T> ensureList(int hint) {
        if (this.queryList == null)
            this.queryList = this.query(hint);
        return this.queryList;
    }

// Container

    @Override
    public SimpleItem<T> getItem(Object itemId) {
        if (!(itemId instanceof Integer))
            return null;
        int index = ((Integer)itemId).intValue();
        T obj = this.getJavaObject(index);
        if (obj == null)
            return null;
        return new SimpleItem<T>(obj, this.propertyMap, this.propertyExtractor);
    }

    @Override
    public Collection<Integer> getItemIds() {
        return new IntList((int)this.ensureList(0).size());
    }

    @Override
    public Set<String> getContainerPropertyIds() {
        return Collections.unmodifiableSet(this.propertyMap.keySet());
    }

    @Override
    public Property getContainerProperty(Object itemId, Object propertyId) {
        SimpleItem<T> item = this.getItem(itemId);
        return item != null ? item.getItemProperty(propertyId) : null;
    }

    @Override
    public Class<?> getType(Object propertyId) {
        PropertyDef<?> propertyDef = this.propertyMap.get(propertyId);
        return propertyDef != null ? propertyDef.getType() : null;
    }

    @Override
    public int size() {
        return (int)this.ensureList(0).size();
    }

    @Override
    public boolean containsId(Object itemId) {
        if (!(itemId instanceof Integer))
            return false;
        int index = ((Integer)itemId).intValue();
        return index >= 0 && index < this.ensureList(index).size();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public Item addItem(Object itemId) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public Item addItem() {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public boolean removeItem(Object itemId) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public boolean addContainerProperty(Object propertyId, Class<?> type, Object defaultValue) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public boolean removeContainerProperty(Object propertyId) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public boolean removeAllItems() {
        throw new UnsupportedOperationException();
    }

// Container.Indexed

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public Object addItemAt(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public Item addItemAt(int index, Object newItemId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer getIdByIndex(int index) {
        return index;
    }

    @Override
    public int indexOfId(Object itemId) {
        if (!(itemId instanceof Integer))
            return -1;
        int index = ((Integer)itemId).intValue();
        if (index < 0 || index >= this.ensureList(index).size())
            return -1;
        return index;
    }

// Container.Ordered

    @Override
    public Integer nextItemId(Object itemId) {
        if (!(itemId instanceof Integer))
            return null;
        int index = ((Integer)itemId).intValue();
        if (index < 0 || index + 1 >= this.ensureList(index).size())
            return null;
        return index + 1;
    }

    @Override
    public Integer prevItemId(Object itemId) {
        if (!(itemId instanceof Integer))
            return null;
        int index = ((Integer)itemId).intValue();
        if (index - 1 < 0 || index >= this.ensureList(index).size())
            return null;
        return index - 1;
    }

    @Override
    public Integer firstItemId() {
        return this.ensureList(0).size() == 0 ? null : 0;
    }

    @Override
    public Integer lastItemId() {
        long size = this.ensureList(0).size();
        return size == 0 ? null : (int)size - 1;
    }

    @Override
    public boolean isFirstId(Object itemId) {
        if (!(itemId instanceof Integer))
            return false;
        int index = ((Integer)itemId).intValue();
        long size = this.ensureList(index).size();
        return size > 0 && index == 0;
    }

    @Override
    public boolean isLastId(Object itemId) {
        if (!(itemId instanceof Integer))
            return false;
        int index = ((Integer)itemId).intValue();
        long size = this.ensureList(index).size();
        return size > 0 && index == size - 1;
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public Item addItemAfter(Object previousItemId) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public Item addItemAfter(Object previousItemId, Object newItemId) {
        throw new UnsupportedOperationException();
    }

// Container.PropertySetChangeNotifier

    @Override
    public void addListener(Container.PropertySetChangeListener listener) {
        super.addListener(listener);
    }

    @Override
    public void removeListener(Container.PropertySetChangeListener listener) {
        super.removeListener(listener);
    }

// Container.ItemSetChangeNotifier

    @Override
    public void addListener(Container.ItemSetChangeListener listener) {
        super.addListener(listener);
    }

    @Override
    public void removeListener(Container.ItemSetChangeListener listener) {
        super.removeListener(listener);
    }

// IntList

    private static class IntList extends AbstractList<Integer> {

        private final int max;

        public IntList(int max) {
            if (max < 0)
                throw new IllegalArgumentException("max < 0");
            this.max = max;
        }

        @Override
        public int size() {
            return this.max;
        }

        @Override
        public Integer get(int index) {
            if (index < 0 || index >= this.max)
                throw new IndexOutOfBoundsException();
            return index;
        }
    }
}

