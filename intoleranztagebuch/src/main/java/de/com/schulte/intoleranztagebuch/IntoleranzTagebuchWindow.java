package de.com.schulte.intoleranztagebuch;

import com.vaadin.addon.touchkit.ui.TouchKitWindow;

public class IntoleranzTagebuchWindow extends TouchKitWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = -55314916647591988L;

	public IntoleranzTagebuchWindow() {
        setCaption("Vornitologist");
        /*
         * These configurations modify how the app behaves as "ios webapp".
         */
        addApplicationIcon(IntoleranzTagebuchApp.get().getURL()
                + "VAADIN/themes/intoleranztagebuch/icon.png");
        setStartupImage(IntoleranzTagebuchApp.get().getURL()
                + "VAADIN/themes/intoleranztagebuch/startup.png");
        setWebAppCapable(true);
        setPersistentSessionCookie(true);
    }
}
