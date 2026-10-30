package menu;

// import packages
import logging.AssignmentLogger;
import internationalization.*;
import java.util.Scanner;
import java.util.ResourceBundle;
import java.util.Locale;
import coffeetype.coffee;
import coffeetype.americano;
import coffeetype.expresso;
import coffeetype.latte;
import exceptions.*;
import Main.main;

public class Menu {
	//default locale
	public static Locale locale = new Locale("en", "GB");

	/**
	 * This method is used to display language menu and catch the exception if any
	 * 
	 * @throws InvalidCoffeeException
	 * @throws InvalidLanguageException
	 */
	public static void displayLanguageMenu() throws InvalidCoffeeException, InvalidLanguageException {// Check exception
		AssignmentLogger.logStaticMethodEntry();
		ResourceBundle bundle = ResourceBundle.getBundle("trans.trans", locale);
		System.out.println(bundle.getString("chooseLanguage"));
		System.out.println("1." + bundle.getString("English"));
		System.out.println("2." + bundle.getString("French"));
		System.out.println("3." + bundle.getString("Exit"));
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if (choice == 1) {
			locale = new Locale("en", "GB");
			LanguageTranslate languageTranslate = new LanguageTranslate();
			languageTranslate.changeLanguage("en", "GB");
			bundle = ResourceBundle.getBundle("trans.trans", locale);
		} else if (choice == 2) {
			locale = new Locale("fr", "FR");
			LanguageTranslate languageTranslate = new LanguageTranslate();
			languageTranslate.changeLanguage("fr", "FR");
			bundle = ResourceBundle.getBundle("trans.trans", locale);
			// if choice is not 1 or 2 throw exception
		} else if (choice == 3) {
			System.out.println("Exiting...");
			main.isRunning = false;
			return;
		} else {
			throw new InvalidLanguageException();
		}
		// stay in the menu until the user chooses to exit
		boolean StayInMenu = true;
		while (StayInMenu && main.isRunning) {
			StayInMenu = displayMenu(bundle);
		}
		AssignmentLogger.logStaticMethodExit();
	}

	/**
	 * This method is used to display the menu and catch the exception if any
	 * 
	 * @param bundle
	 * @throws InvalidCoffeeException
	 */
	public static boolean displayMenu(ResourceBundle bundle) throws InvalidCoffeeException {
		AssignmentLogger.logStaticMethodEntry();
		System.out.println(bundle.getString("coffeeChoose"));
		System.out.println("1." + bundle.getString("Americano"));
		System.out.println("2." + bundle.getString("Expresso"));
		System.out.println("3." + bundle.getString("Latte"));
		System.out.println("4." + bundle.getString("Exit"));
		System.out.println("5." + bundle.getString("Back"));
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		// check the choice and create the coffee
		coffee selectedCoffee = null;
		if (choice == 1) {
			System.out.println(bundle.getString("preparing") + " " + bundle.getString("Americano"));
			selectedCoffee = new americano();
		}
		else if (choice == 2) {
			System.out.println(bundle.getString("preparing") + " " + bundle.getString("Expresso"));
			selectedCoffee = new expresso();
		}
		else if (choice == 3) {
			System.out.println(bundle.getString("preparing") + " " + bundle.getString("Latte"));
			selectedCoffee = new latte();
		}
		// will exit code by breaking the while loop
		else if (choice == 4) {
			main.isRunning = false;
		}
		// will exit the menu by returning false
		else if (choice == 5) {
			return false;
		} 
		else {
			throw new InvalidCoffeeException();
		}
		if (selectedCoffee != null) {
			selectedCoffee.preprare();
		}
		AssignmentLogger.logStaticMethodExit();
		return true;
	}

}
