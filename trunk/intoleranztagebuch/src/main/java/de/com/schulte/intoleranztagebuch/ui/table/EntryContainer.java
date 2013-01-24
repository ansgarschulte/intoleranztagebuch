package de.com.schulte.intoleranztagebuch.ui.table;

import javax.annotation.PostConstruct;

import com.vaadin.data.util.IndexedContainer;

public class EntryContainer extends IndexedContainer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7405270341089462815L;
	private static String[] fields = { "First Name", "Last Name", "Company",
			"Mobile Phone", "Work Phone", "Home Phone", "Work Email",
			"Home Email", "Street", "Zip", "City", "State", "Country" };
	String[] fnames = { "Peter", "Alice", "Joshua", "Mike", "Olivia", "Nina",
			"Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene", "Lisa", "Marge" };
	String[] lnames = { "Smith", "Gordon", "Simpson", "Brown", "Clavel",
			"Simons", "Verne", "Scott", "Allison", "Gates", "Rowling", "Barks",
			"Ross", "Schneider", "Tate" };

	@PostConstruct
	protected void init() {
		createDummyData();
	}

	private void createDummyData() {
		for (String p : fields) {
			addContainerProperty(p, String.class, "");
		}

		// Create dummy data by randomly combining first and last names
		for (int i = 0; i < 1000; i++) {
			Object id = addItem();
			getContainerProperty(id, "First Name").setValue(
					fnames[(int) (fnames.length * Math.random())]);
			getContainerProperty(id, "Last Name").setValue(
					lnames[(int) (lnames.length * Math.random())]);
		}
	}

}
