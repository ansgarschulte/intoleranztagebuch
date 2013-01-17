package de.com.schulte.intoleranztagebuch;

import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class IntoleranzTagebuchApp extends TouchKitApplication
{
    @Override
    public void onBrowserDetailsReady() {
        Button button = new Button("Click Me ATZE NOW");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                event.getButton().getWindow().addComponent(new Label("Thank you for clicking"));
            }
        });
        getMainWindow().addComponent(button);
    }

    
}
