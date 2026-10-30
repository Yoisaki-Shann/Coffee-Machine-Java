package exceptions;

import java.util.ResourceBundle;
import menu.Menu;

public class InvalidCoffeeException extends Exception {
	
	/**
	 * Constructor for InvalidCoffeeException
	 */
	public InvalidCoffeeException() {
		super(ResourceBundle.getBundle("trans.trans", Menu.locale).getString("InvalidCoffeeType"));
	}


}