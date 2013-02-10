package de.com.schulte.intoleranztagebuch.ui;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.formbinder.PreCreatedFieldsHelper;
import org.vaadin.addon.formbinder.PropertyId;
import org.vaadin.addon.formbinder.ViewBoundForm;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;

import de.com.schulte.intoleranztagebuch.IntoleranzTagebuchApp;
import de.com.schulte.intoleranztagebuch.model.Entry;
import de.com.schulte.intoleranztagebuch.model.EntryDB;
import de.com.schulte.intoleranztagebuch.util.Translations;

public class EntryEditor extends NavigationView implements ClickListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7789280347185252987L;
	private Button cancel = new Button(null, this);
	private Button save = new Button(null, this);
	private Button deleteButton = new Button(null, this);

	private Entry entry = new Entry();

	private CssLayout layout = new CssLayout();
	private ResourceBundle tr;
	private FormLayout mealLayout = new FormLayout();
	@PropertyId("discomforts")
	private ComboBox discomfortsField;
	@PropertyId("meal")
	private TextArea mealField;
	@PropertyId("drink")
	private TextArea drinkField;
	@PropertyId("eatTime")
	private DateField eatTimeField;
	@PropertyId("discomfortTime")
	private DateField discomfortTimeField;
	@PropertyId("supposedCause")
	private TextArea supposedCauseField;
	@PropertyId("assistanceUsed")
	private ComboBox assitanceUsedField;

	@Autowired
	private EntryDB entryDB;
	@Autowired
	private LatestEntries latestEntries;
	private ViewBoundForm viewBoundForm;

	public EntryEditor() {
	}

	public void init() {
		Locale locale = IntoleranzTagebuchApp.getApp().getLocale();
		// set some sane default values for the entry
		entry.setEatTime(new Date());

		tr = Translations.get(locale);

		setCaption(tr.getString("new Entry"));

		// add and configure save and cancel buttons
		cancel.setCaption(tr.getString("Cancel"));
		save.setCaption(tr.getString("Save"));
		deleteButton.setCaption(tr.getString("Delete"));
		setLeftComponent(cancel);
		setRightComponent(save);

		VerticalComponentGroup formWrapper = new VerticalComponentGroup();
		formWrapper.setCaption(tr.getString("Meal details"));
		mealLayout.setMargin(false);
		mealLayout.setSpacing(false);
		Form form = new Form(mealLayout) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7582239125245891544L;

			@Override
			protected void attachField(Object propertyId, Field field) {
				// NOP : pre-created-fields-pattern
			}
		};
		form.setWriteThrough(true);
		formWrapper.addComponent(form);

		// Configure fields

		mealField = new TextArea(tr.getString("meal"));
		mealField.setWidth("100%");
		mealField.setDebugId("meal");
		drinkField = new TextArea(tr.getString("drink"));
		drinkField.setWidth("100%");
		drinkField.setDebugId("drink");
		eatTimeField = new DateField(tr.getString("mealtime"));
		eatTimeField.setResolution(DateField.RESOLUTION_MIN);
		eatTimeField.setWidth("100%");
		eatTimeField.setLocale(Locale.GERMANY);

		assitanceUsedField = new ComboBox(tr.getString("assistanceUsed"));
		assitanceUsedField.setContainerDataSource(getAllAssistanceUsed(locale));
		assitanceUsedField.setWidth("100%");
		assitanceUsedField.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		assitanceUsedField.setItemCaptionPropertyId("lang");
		assitanceUsedField.setNullSelectionAllowed(true);

		// add fields to form
		mealLayout.addComponent(eatTimeField);
		mealLayout.addComponent(mealField);
		mealLayout.addComponent(drinkField);
		mealLayout.addComponent(assitanceUsedField);

		// discomforts
		discomfortTimeField = new DateField(tr.getString("discomfortTime"));
		discomfortTimeField.setResolution(DateField.RESOLUTION_MIN);
		discomfortTimeField.setWidth("100%");
		discomfortTimeField.setLocale(Locale.GERMANY);

		discomfortsField = new ComboBox(tr.getString("discomforts"));
		discomfortsField.setContainerDataSource(getDiscomforts(locale));
		discomfortsField.setWidth("100%");
		discomfortsField.setFilteringMode(ComboBox.FILTERINGMODE_CONTAINS);
		discomfortsField.setItemCaptionPropertyId("lang");
		discomfortsField.setNullSelectionAllowed(true);

		supposedCauseField = new TextArea(tr.getString("supposed Cause"));
		supposedCauseField.setWidth("100%");
		supposedCauseField.setDebugId("supposedCause");

		VerticalComponentGroup discomfortLayout = new VerticalComponentGroup();
		discomfortLayout.setCaption(tr.getString("discomfort details"));

		discomfortLayout.addComponent(discomfortTimeField);
		discomfortLayout.addComponent(discomfortsField);
		discomfortLayout.addComponent(supposedCauseField);

		// Also add button to trigger location selection via map
		form.setFormFieldFactory(new PreCreatedFieldsHelper(this));
		form.setItemDataSource(new BeanItem<Entry>(entry));

		layout.addComponent(formWrapper);
		layout.addComponent(discomfortLayout);
		layout.addComponent(deleteButton);

		layout.setMargin(true);

		viewBoundForm = new ViewBoundForm();
		viewBoundForm.setLayout(layout);
		// configure form (delegated to PreCreatedFieldsHelper) to search
		// suitable fields from sub form views
		viewBoundForm.setCustomFieldSources(this);

		viewBoundForm.setItemDataSource(new BeanItem<Entry>(entry));

		setContent(viewBoundForm);
	}

	private Container getDiscomforts(Locale locale) {
		IndexedContainer indexedContainer = new IndexedContainer(
				entryDB.getAllDiscomforts());
		indexedContainer.addContainerProperty("lang", String.class, "");
		ResourceBundle tr = Translations.get(locale);

		for (int i = 0; i < entryDB.getAllDiscomforts().size(); i++) {
			String idByIndex = (String) indexedContainer.getIdByIndex(i);
			String value = "";
			if (StringUtils.isNotBlank(idByIndex)) {
				value = tr.getString(idByIndex);
			}
			indexedContainer.getItem(idByIndex).getItemProperty("lang")
					.setValue(value);
		}

		return indexedContainer;
	}

	private Container getAllAssistanceUsed(Locale locale) {
		IndexedContainer indexedContainer = new IndexedContainer(
				entryDB.getAllAssistanceUsed());
		indexedContainer.addContainerProperty("lang", String.class, "");
		ResourceBundle tr = Translations.get(locale);

		for (int i = 0; i < entryDB.getAllAssistanceUsed().size(); i++) {
			String idByIndex = (String) indexedContainer.getIdByIndex(i);
			String value = "";
			if (StringUtils.isNotBlank(idByIndex)) {
				value = tr.getString(idByIndex);
			}
			indexedContainer.getItem(idByIndex).getItemProperty("lang")
					.setValue(value);
		}

		return indexedContainer;
	}

	public void buttonClick(ClickEvent event) {
		if (event.getButton() == save) {
			if (StringUtils.isEmpty(entry.getMeal())) {
				getWindow().showNotification(
						tr.getString("Meal must be defined"));
				return;
			}

			entryDB.persist(entry);
		} else if (event.getButton() == deleteButton) {
			entryDB.deleteEntry(entry);
		}
		getNavigationManager().navigateTo(latestEntries);
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		String discomforts = entry.getDiscomforts();
		if (StringUtils.isBlank(discomforts)) {
			discomfortsField.select(null);
		} else {
			discomfortsField.select(discomforts);
		}
		String assitanceUsed = entry.getAssistanceUsed();
		if (StringUtils.isBlank(assitanceUsed)) {
			assitanceUsedField.select(null);
		} else {
			assitanceUsedField.select(assitanceUsed);
		}
		this.entry = entry;
		viewBoundForm.setItemDataSource(new BeanItem<Entry>(entry));
	}

	@Override
	protected void onBecomingVisible() {
		super.onBecomingVisible();
	}

}
