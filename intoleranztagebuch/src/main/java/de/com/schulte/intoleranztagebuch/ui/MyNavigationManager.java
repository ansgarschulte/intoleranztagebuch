package de.com.schulte.intoleranztagebuch.ui;

import com.vaadin.addon.touchkit.ui.NavigationManager;

public class MyNavigationManager extends NavigationManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5474560195730482858L;

	public MyNavigationManager() {
		navigateTo(new EntryEditor());
	}

}
