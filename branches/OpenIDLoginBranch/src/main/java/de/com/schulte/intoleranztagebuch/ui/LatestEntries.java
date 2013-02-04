package de.com.schulte.intoleranztagebuch.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.data.Container;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;

import de.com.schulte.intoleranztagebuch.IntoleranzTagebuchApp;
import de.com.schulte.intoleranztagebuch.model.Entry;
import de.com.schulte.intoleranztagebuch.model.EntryDB;
import de.com.schulte.intoleranztagebuch.ui.table.EntryContainer;
import de.com.schulte.intoleranztagebuch.util.Translations;

public class LatestEntries extends NavigationView implements ClickListener {

	private static final Log LOG = LogFactory.getLog(LatestEntries.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 5042283985957752752L;

	@Autowired
	private EntryEditor entryEditor;

	@Autowired
	private MyNavigationManager navigationManager;

	@Autowired
	private EntryDB entryDB;

	private Button addEntry = new Button(null, this);

	private ResourceBundle tr;

	private Table table = new Table() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6451968215677625867L;
		private DateFormat df;

		@Override
		protected String formatPropertyValue(Object rowId, Object colId,
				com.vaadin.data.Property property) {
			// if (colId.equals("location")) {
			// ObservationPoint value2 = (ObservationPoint) property
			// .getValue();
			// return value2.getName();
			// } else if (colId.equals("species")) {
			// Species species = (Species) property.getValue();
			// return tr.getString(species.getName());
			// } else
			if (colId.equals("Datum")) {
				Date date = (Date) property.getValue();
				if (df == null) {
					df = SimpleDateFormat.getDateInstance(
							SimpleDateFormat.SHORT, IntoleranzTagebuchApp.get()
									.getLocale());
				}
				return df.format(date);
			} else {
				return super.formatPropertyValue(rowId, colId, property);
			}
		};
	};

	@Override
	public void attach() {
		super.attach();
		if (tr == null) {
			buildView();
		}
	}

	private String dateToString(Date date) {
		DateFormat df = SimpleDateFormat.getDateTimeInstance(
				SimpleDateFormat.SHORT, SimpleDateFormat.SHORT,
				IntoleranzTagebuchApp.get().getLocale());
		return df.format(date);
	}

	private void buildView() {
		tr = Translations.get(getLocale());
		setCaption(tr.getString("HistorieTabelle"));

		table = new Table("Essen");
		/*
		 * Define the names and data types of columns. The "default value"
		 * parameter is meaningless here.
		 */
		table.addContainerProperty("Datum", String.class, null);
		table.addContainerProperty("Essen", String.class, null);

		table.setSizeFull();
		setContent(table);
		//
		addEntry.setIcon(new ThemeResource("linegraphics/plus.png"));
		setLeftComponent(null);
		setRightComponent(addEntry);

		table.addListener(new ItemClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1481244218175558919L;

			public void itemClick(ItemClickEvent event) {
				Entry e = (Entry) event.getItemId();
				showEntryDetails(e);
			}

		});

	}

	private void refreshTable() {
		List<Entry> allEntries = entryDB.getAllEntries();
		fillTable(allEntries);
	}

	private void fillTable(List<Entry> allEntries) {
		// Container containerDataSource = table.getContainerDataSource();
		// containerDataSource.removeAllItems();
		// for (Object entry : entries) {
		// containerDataSource.addItem(entry);
		// }
		Collections.sort(allEntries);
		table.removeAllItems();
		for (Entry entry : allEntries) {
			table.addItem(new Object[] { dateToString(entry.getEatTime()),
					entry.getMeal() }, entry);
		}
	}

	private void showEntryDetails(final Entry e) {
		LOG.debug("Show Entry" + e);
		e.setDiscomfortTime(new Date());
		entryEditor.setEntry(e);
		navigationManager.navigateTo(entryEditor);
		// popover.showRelativeTo(getNavigationBar());
	}

	//
	private void populateTable() {
		Container entriesContainer = new EntryContainer();
		table.setContainerDataSource(entriesContainer);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (addEntry == event.getButton()) {
			showEntryDetails(new Entry());
			// getWindow().addWindow(popover);
		} else {
		}
	}

	// public void cleanup() {
	// ObservationDB.unregisterContainer(table.getContainerDataSource());
	// }
	@Override
	protected void onBecomingVisible() {
		super.onBecomingVisible();
		refreshTable();
	}
}
