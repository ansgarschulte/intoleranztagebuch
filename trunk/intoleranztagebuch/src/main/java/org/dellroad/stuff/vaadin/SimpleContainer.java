
/*
 * Copyright (C) 2011 Archie L. Cobbs. All rights reserved.
 *
 * $Id: SimpleContainer.java 574 2012-11-30 18:29:35Z archie.cobbs $
 */

package org.dellroad.stuff.vaadin;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An {@link AbstractSimpleContainer} with {@link Integer} item IDs.
 *
 * <p>
 * Use {@link #load} to (re)load the container.
 *
 * @param <T> the type of the Java objects that back each {@link com.vaadin.data.Item} in the container
 * @see AbstractSimpleContainer
 */
@SuppressWarnings("serial")
public class SimpleContainer<T> extends AbstractSimpleContainer<Integer, T> {

    private ArrayList<T> items = new ArrayList<T>(0);

    /**
     * Constructor.
     *
     * <p>
     * After using this constructor, subsequent invocations of {@link #setPropertyExtractor setPropertyExtractor()}
     * and {@link #setProperties setProperties()} are required to define the properties of this container
     * and how to extract them.
     */
    public SimpleContainer() {
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
    public SimpleContainer(PropertyExtractor<? super T> propertyExtractor) {
        super(propertyExtractor);
    }

    /**
     * Primary constructor.
     *
     * @param propertyExtractor used to extract properties from the underlying Java objects;
     *  may be null but then container is not usable until one is configured via
     * {@link #setPropertyExtractor setPropertyExtractor()}
     * @param propertyDefs container property definitions; null is treated like the empty set
     */
    public SimpleContainer(PropertyExtractor<? super T> propertyExtractor, Collection<? extends PropertyDef<?>> propertyDefs) {
        super(propertyExtractor, propertyDefs);
    }

    @Override
    public T getJavaObject(Object itemId) {
        if (!(itemId instanceof Integer))
            return null;
        int index = ((Integer)itemId).intValue();
        if (index < 0 || index >= this.items.size())
            return null;
        return this.items.get(index);
    }

    @Override
    protected void resetItemIds() {
        this.items = new ArrayList<T>();
    }

    @Override
    protected Integer generateItemId(T obj) {
        int itemId = this.items.size();
        this.items.add(obj);
        return itemId;
    }
}

