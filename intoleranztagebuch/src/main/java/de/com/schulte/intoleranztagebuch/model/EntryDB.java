package de.com.schulte.intoleranztagebuch.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.data.Container;
import com.vaadin.data.util.IndexedContainer;

import de.com.schulte.intoleranztagebuch.util.Translations;

public class EntryDB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6109802182896950053L;

	public Container getDiscomforts(Locale locale) {
		IndexedContainer indexedContainer = new IndexedContainer(
				getAllDiscomforts());
		indexedContainer.addContainerProperty("lang", String.class, "");
		ResourceBundle tr = Translations.get(locale);

		for (int i = 0; i < getAllDiscomforts().size(); i++) {
			String idByIndex = (String) indexedContainer.getIdByIndex(i);
			indexedContainer.getItem(idByIndex).getItemProperty("lang")
					.setValue(tr.getString(idByIndex));
		}

		return indexedContainer;
	}

	private List<String> getAllDiscomforts() {
		List<String> discomforts = new ArrayList<String>();
		discomforts.add("Appetitlosigkeit");
		discomforts.add("Aufstoßen");
		discomforts.add("Bauchschmerzen");
		discomforts.add("Blähbauch");
		discomforts.add("Darm grummeln");
		discomforts.add("Durchfall");
		discomforts.add("Krämpfe");
		discomforts.add("Plötzlich einsetzender Stuhldrang");
		discomforts.add("Übelkeit");
		return discomforts;
	}

	public void persist(Entry entry) {
		System.out.println(entry.toString());
	}

}
