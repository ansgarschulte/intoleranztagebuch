package de.com.schulte.intoleranztagebuch.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translations {
	private static Locale[] locales = new Locale[] {
		Locale.GERMAN, Locale.ENGLISH
	};

	public static Locale[] getAvailableLocales() {
		return locales;
	}
	
	public static ResourceBundle get(Locale locale) {
		if(locale == null) {
			locale = Locale.GERMAN;
		}
		return ResourceBundle.getBundle("NamesBundle", locale);
	}
}
