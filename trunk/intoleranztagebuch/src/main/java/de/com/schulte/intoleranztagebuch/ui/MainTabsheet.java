package de.com.schulte.intoleranztagebuch.ui;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.addon.touchkit.ui.TabBarView;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.TabSheet.Tab;

import de.com.schulte.intoleranztagebuch.IntoleranzTagebuchApp;
import de.com.schulte.intoleranztagebuch.util.Translations;

/**
 * This is the main view for the application. It displays a tabbar via one can
 * choose one of the sub views.
 */
public class MainTabsheet extends TabBarView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5882369226772545119L;
	@Autowired
	private MyNavigationManager myNavigationManager;
	@Autowired
	private LatestEntries latestEntries;
	@Autowired
	private EntryEditor entryEditor;

	public MainTabsheet() {
	}

	public void init() {
		ResourceBundle tr = Translations.get(IntoleranzTagebuchApp.get()
				.getLocale());
		/*
		 * Populate main views
		 */
		LatestEntries lastEntries = latestEntries;
		Tab addTab = addTab(lastEntries);
		addTab.setIcon(new ThemeResource("linegraphics/tools.png"));
		addTab.setCaption("LatestEntries");
		MyNavigationManager navigationManager = myNavigationManager;
		addTab = addTab(navigationManager);
		addTab.setIcon(new ThemeResource("tabsheet/pencil.png"));
		addTab.setCaption("Editor");

		/*
		 * Make settings view as the default. This would not be best option for
		 * a real application, but it also serves as our demos welcome page.
		 */
		setSelectedTab(navigationManager);
		entryEditor.init();
		myNavigationManager.navigateTo(entryEditor);
	}

	/**
	 * Latest observation view needs to do some cleanup to let garbage collector
	 * to do its job. This is due to our simple in memory "service layer"
	 * 
	 * @see com.vaadin.ui.AbstractComponentContainer#detach()
	 */
	@Override
	public void detach() {
		super.detach();
	}

}
