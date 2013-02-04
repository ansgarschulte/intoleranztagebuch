package de.com.schulte.intoleranztagebuch;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.vaadin.openid.OpenIdHandler;
import org.vaadin.openid.OpenIdHandler.UserAttribute;

import com.vaadin.addon.touchkit.ui.TouchKitWindow;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.com.schulte.intoleranztagebuch.model.EntryDB;
import de.com.schulte.intoleranztagebuch.model.User;
import de.com.schulte.intoleranztagebuch.ui.MainTabsheet;
import de.flexguse.vaadin.addon.spring.touchkit.SpringTouchkitApplication;

/**
 * The Application's "main" class
 */
public class IntoleranzTagebuchApp extends SpringTouchkitApplication {
	// @Override
	// public void onBrowserDetailsReady() {
	// Button button = new Button("Click Me ATZE NOW");
	// button.addListener(new Button.ClickListener() {
	// public void buttonClick(ClickEvent event) {
	// event.getButton().getWindow().addComponent(new
	// Label("Thank you for clicking"));
	// }
	// });
	// getMainWindow().addComponent(button);
	// }

	/**
	 * 
	 */
	private static final long serialVersionUID = 7507626506862196908L;
	private TouchKitWindow mainWindow;
	@Autowired
	private EntryDB entryDB;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private MongoDbFactory mongoDbFactory;
	@Autowired
	private MainTabsheet mainTabsheet;
	@Autowired
	private TouchKitWindow intoleranzTagebuchWindow;

	private static final Log LOG = LogFactory
			.getLog(IntoleranzTagebuchApp.class);

	// @Override
	// public void init() {
	// /*
	// * Custom configurations (app icons etc) for main window need to be set
	// * eagerly as they are written on the "host page".
	// */
	// // initBeans();
	// configureMainWindow();
	// setTheme("intoleranztagebuch");
	// // setUser(Translations.get(getLocale()).getObject("Willy Wilderness"));
	// }

	@Override
	protected void initSpringApplication(
			ConfigurableWebApplicationContext context) {

		/*
		 * Initialise the application. Don't forget to run the init method in
		 * the super class, otherwise you get an error the Vaadin Application
		 * Window can't be found.
		 */
		super.initSpringApplication(context);

		// if (entryDB.login("karin", "karin") == null) {
		// if (!entryDB.register("karin", "karin", "egal", "Karin",
		// "aa@bb.com")) {
		// LOG.error("Irgendwas ist kommisch");
		// } else {
		// entryDB.login("karin", "karin");
		// }
		// }
		setTheme("intoleranztagebuch");
		openIdInit();
		// initITB();
	}

	private void initITB(TouchKitWindow touchKitWindow) {
		// configureMainWindow();
		mainTabsheet.init();
		mainWindow.removeAllComponents();
		mainWindow.setContent(mainTabsheet);
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

	}

	// private void configureMainWindow() {
	// mainWindow = intoleranzTagebuchWindow;
	// setMainWindow(mainWindow);
	// }

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

	public EntryDB getEntryDB() {
		return entryDB;
	}

	public void openIdInit() {
		VerticalLayout container = new VerticalLayout();
		container.setSpacing(true);
		container.setMargin(true);

		// TouchKitWindow mainWindow = new TouchKitWindow("OpenId test",
		// container);
		mainWindow = new IntoleranzTagebuchWindow();
		setMainWindow(mainWindow);
		mainWindow.addComponent(container);
		final OpenIdHandler openIdHandler = new OpenIdHandler(this);
		openIdHandler.setRequestedAttributes(UserAttribute.values());

		final HorizontalLayout linkHolder = new HorizontalLayout();
		linkHolder.setSpacing(true);
		linkHolder
				.addComponent(createLoginLink(openIdHandler,
						"https://www.google.com/accounts/o8/id",
						"Log in using Google"));
		linkHolder.addComponent(createLoginLink(openIdHandler,
				"https://me.yahoo.com", "Log in using Yahoo"));

		container.addComponent(linkHolder);

		openIdHandler.addListener(new OpenIdHandler.OpenIdLoginListener() {
			public void onLogin(String id, Map<UserAttribute, String> userInfo) {
				User openIDUser = new User();
				openIDUser.setId(id);
				openIDUser.setEmail(userInfo.get("email"));
				openIDUser.setName(userInfo.get("firstname"));
				openIDUser.setSurname(userInfo.get("lastname"));
				entryDB.setUser(openIDUser);
				LOG.info("Logged in User: " + openIDUser);
				initITB(getMainWindow());
				//
				// Window window = getMainWindow();
				// window.removeComponent(linkHolder);
				// window.addComponent(new Label("Logged in identity: " + id));
				// Set<UserAttribute> missingFields = EnumSet
				// .allOf(UserAttribute.class);
				// for (UserAttribute field : userInfo.keySet()) {
				// window.addComponent(new Label(field + ": "
				// + userInfo.get(field)));
				// missingFields.remove(field);
				// }
				// for (UserAttribute registrationFields : missingFields) {
				// window.addComponent(new Label(registrationFields
				// + " not provided"));
				// }

				openIdHandler.close();
			}

			public void onCancel() {
				getMainWindow().removeComponent(linkHolder);
				getMainWindow().addComponent(
						new Label("Too sad you didn't want to log in."));

				openIdHandler.close();
			}
		});
	}

	private static Link createLoginLink(OpenIdHandler openIdHandler, String id,
			String caption) {
		return new Link(caption, openIdHandler.getLoginResource(id),
				"openidLogin", 600, 400, Window.BORDER_NONE);
	}

}
