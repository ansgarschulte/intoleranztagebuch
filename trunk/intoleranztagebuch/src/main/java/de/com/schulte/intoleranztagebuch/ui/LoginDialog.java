package de.com.schulte.intoleranztagebuch.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.formbinder.ViewBoundForm;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import de.com.schulte.intoleranztagebuch.IntoleranzTagebuchApp;
import de.com.schulte.intoleranztagebuch.model.EntryDB;
import de.com.schulte.intoleranztagebuch.model.LoginUser;
import de.com.schulte.intoleranztagebuch.model.User;
import de.com.schulte.intoleranztagebuch.util.CookieService;

public class LoginDialog extends NavigationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8387172570367347710L;
	private Button registerButton;
	private Button loginButton;
	private PasswordField passwordTextField;
	private TextField userTextField;
	private ViewBoundForm viewBoundForm;
	private LoginUser loginUser = new LoginUser();
	private FormLayout loginLayout = new FormLayout();
	private CssLayout layout = new CssLayout();

	private static final Log LOG = LogFactory.getLog(LoginDialog.class);

	@Autowired
	private EntryDB entryDB;

	public LoginDialog() {

	}

	public void init() {
		buildLayout();
		loginButton.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				User user = entryDB.login((String) userTextField.getValue(),
						(String) passwordTextField.getValue());
				if (user != null) {
					// login success
					try {
						loginUser = new LoginUser((String) userTextField
								.getValue(), (String) passwordTextField
								.getValue());
						CookieService.saveCookie(loginUser,
								IntoleranzTagebuchApp.getApp().getResponse());
					} catch (Exception e) {
						getWindow().showNotification(
								"Cookie Speicher fehlgeschlagen");
						e.printStackTrace();
						LOG.error(e);
					}
					IntoleranzTagebuchApp.getApp().initITB();
				} else {
					getWindow().showNotification("Login fehlgeschlagen");
					return;
				}

			}
		});
	}

	private void buildLayout() {
		// common part: create layout
		this.setCaption("Intoleranz Tagebuch");
		VerticalComponentGroup formWrapper = new VerticalComponentGroup();
		formWrapper.setCaption("Login");
		loginLayout.setMargin(false);
		loginLayout.setSpacing(false);
		Form form = new Form(loginLayout) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7582239125245891544L;

			@Override
			protected void attachField(Object propertyId, Field field) {
			}
		};
		form.setWriteThrough(true);
		formWrapper.addComponent(form);

		// userTextField
		userTextField = new TextField();
		userTextField.setCaption("Benutzername");
		userTextField.setImmediate(false);
		userTextField.setWidth("-1px");
		userTextField.setHeight("-1px");
		loginLayout.addComponent(userTextField);

		// passwordTextField
		passwordTextField = new PasswordField();
		passwordTextField.setCaption("Passwort");
		passwordTextField.setImmediate(false);
		passwordTextField.setWidth("-1px");
		passwordTextField.setHeight("-1px");
		loginLayout.addComponent(passwordTextField);

		HorizontalLayout horizontalLayout = new HorizontalLayout();

		// registerButton
		registerButton = new Button();
		registerButton.setCaption("Register");
		registerButton.setImmediate(false);
		registerButton.setWidth("-1px");
		registerButton.setHeight("-1px");
		horizontalLayout.addComponent(registerButton);

		// loginButton
		loginButton = new Button();
		loginButton.setCaption("Login");
		loginButton.setImmediate(false);
		loginButton.setWidth("-1px");
		loginButton.setHeight("-1px");
		horizontalLayout.addComponent(loginButton);

		layout.addComponent(formWrapper);
		layout.addComponent(horizontalLayout);

		layout.setMargin(true);
		viewBoundForm = new ViewBoundForm();
		viewBoundForm.setLayout(layout);
		// configure form (delegated to PreCreatedFieldsHelper) to search
		// suitable fields from sub form views
		viewBoundForm.setCustomFieldSources(this);

		viewBoundForm.setItemDataSource(new BeanItem<LoginUser>(loginUser));

		setContent(viewBoundForm);

	}

}
