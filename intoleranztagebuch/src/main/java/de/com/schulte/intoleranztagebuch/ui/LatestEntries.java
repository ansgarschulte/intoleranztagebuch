package de.com.schulte.intoleranztagebuch.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.data.Container;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 5042283985957752752L;

	private Button addEntry = new Button(null, this);

	private ResourceBundle tr;

	private Table table = new Table() {
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

		table = new Table("This is my Table");

		/*
		 * Define the names and data types of columns. The "default value"
		 * parameter is meaningless here.
		 */
		table.addContainerProperty("Datum", String.class, null);
		table.addContainerProperty("Essen", String.class, null);

		EntryDB entryDB = IntoleranzTagebuchApp.getApp().getEntryDB();
		List<Entry> allEntries = entryDB.getAllEntries();
		for (Entry entry : allEntries) {
			table.addItem(new Object[] { dateToString(entry.getEatTime()),
					entry.getMeal() }, entry.getId());
		}

		table.setSizeFull();
		// populateTable();
		// table.setVisibleColumns(new Object[] { "First Name", "Last Name" });
		// table.setColumnHeader("First Name", "First Name");
		// table.setColumnHeader("Last Name", "Last Name");
		//
		// // table.setColumnExpandRatio("observationTime", 1);
		// table.setColumnExpandRatio("datetime", 1);
		// table.setColumnExpandRatio("essen", 0.5f);
		setContent(table);
		//
		addEntry.setIcon(new ThemeResource("linegraphics/plus.png"));
		setRightComponent(addEntry);
		//
		// table.addListener(new ItemClickListener() {
		// public void itemClick(ItemClickEvent event) {
		// // Observation o = (Observation) event.getItemId();
		// // showObservationDetails(o);
		// }
		//
		// });

	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	// private void showObservationDetails(final Observation o) {
	// final ObservationDetailPopover popover = new ObservationDetailPopover(o);
	// popover.showRelativeTo(getNavigationBar());
	// }
	//
	private void populateTable() {
		Container entriesContainer = new EntryContainer();
		table.setContainerDataSource(entriesContainer);
	}
	//
	// public void buttonClick(ClickEvent event) {
	// if (addObservation == event.getButton()) {
	// Popover popover = new Popover();
	// popover.setSizeFull();
	// popover.setModal(false);
	// popover.setContent(new AddObservationView(null, null));
	// getWindow().addWindow(popover);
	// } else {
	// }
	// }
	//
	// public void cleanup() {
	// ObservationDB.unregisterContainer(table.getContainerDataSource());
	// }

}
