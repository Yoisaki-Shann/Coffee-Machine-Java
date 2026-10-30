package internationalization;

import logging.AssignmentLogger;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageTranslate {
	/**
	 * This method is used to change the language of the program
	 * @param language
	 * @param country
	 */

	public void changeLanguage(String language, String country) {
		AssignmentLogger.logMethodEntry(this);
		//create the locale
		Locale locale = new Locale(language, country);
		ResourceBundle bundle = ResourceBundle.getBundle("trans.trans", locale);
		System.out.println("----------------------------------------");
		System.out.println(bundle.getString("switchLanguage"));
		System.out.println("----------------------------------------");
		//print the languages
		System.out.println("1." + bundle.getString("English"));
		System.out.println("2." + bundle.getString("French"));
		System.out.println("3." + bundle.getString("Exit"));

		System.out.println("\n");
		//print the coffees
		System.out.println(bundle.getString("coffeeChoose"));
		System.out.println("1." + bundle.getString("Americano"));
		System.out.println("2." + bundle.getString("Expresso"));
		System.out.println("3." + bundle.getString("Latte"));

		AssignmentLogger.logMethodExit(this);
	}

}
