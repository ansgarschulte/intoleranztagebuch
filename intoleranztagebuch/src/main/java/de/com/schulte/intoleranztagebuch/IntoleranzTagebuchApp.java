package de.com.schulte.intoleranztagebuch;

import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.addon.touchkit.ui.TouchKitWindow;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import de.com.schulte.intoleranztagebuch.ui.MainTabsheet;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class IntoleranzTagebuchApp extends TouchKitApplication
{
//    @Override
//    public void onBrowserDetailsReady() {
//        Button button = new Button("Click Me ATZE NOW");
//        button.addListener(new Button.ClickListener() {
//            public void buttonClick(ClickEvent event) {
//                event.getButton().getWindow().addComponent(new Label("Thank you for clicking"));
//            }
//        });
//        getMainWindow().addComponent(button);
//    }

	private TouchKitWindow mainWindow;
	
    @Override
    public void init() {
        /*
         * Custom configurations (app icons etc) for main window need to be set
         * eagerly as they are written on the "host page".
         */
        configureMainWindow();
        setTheme("intoleranztagebuch");
//        setUser(Translations.get(getLocale()).getObject("Willy Wilderness"));
    }

    /**
     * This method is convenience method for developer. At this point the GWT
     * built client side has initialized and collected all relevant information
     * that might be needed for instantiating the app. Here we could for example
     * check the clients display size and serve appropriately designed variation
     * of the UI.
     * <p>
     * In this particular demo application we actually could do everything
     * eagerly in the init method as we serve the same UI for all clients. But
     * we have left something here for demo purposes. We set MainTabSheet as the
     * main view for this application and add uri handler that will serve as a
     * proxy for bird pictures from Wikipedia.
     * 
     * @see com.vaadin.addon.touchkit.ui.TouchKitApplication#onBrowserDetailsReady()
     * @see MainTabSheet
     */
    @Override
    public void onBrowserDetailsReady() {
        mainWindow.setContent(new MainTabsheet());
    }

    private void configureMainWindow() {
        mainWindow = new IntoleranzTagebuchWindow();
        setMainWindow(mainWindow);
    }
    /**
     * TouchKitApplication already provides access to currently active
     * application instance with "thread local pattern". The approach is handy
     * as we commonly store e.g. settings in the application instance (location
     * information in this example). Otherwise we'd need to pass references to
     * UI components in constructors or provided another mechanism to access
     * active class (e.g. CDI). This is a better typed version of the one that
     * TouchKitApplication provides for convenience.
     * 
     * @return the currently active Vornitologist application.
     */
    public static IntoleranzTagebuchApp getApp() {
        return (IntoleranzTagebuchApp) get();
    }
}
