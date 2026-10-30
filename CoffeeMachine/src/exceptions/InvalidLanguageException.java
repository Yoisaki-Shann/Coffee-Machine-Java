package exceptions;

import java.util.ResourceBundle;
import menu.Menu;

public class InvalidLanguageException extends Exception {

	/**
	 * Constructor for InvalidLanguageException
	 * 
	 */
	public InvalidLanguageException() {
		super(ResourceBundle.getBundle("trans.trans", Menu.locale).getString("InvalidLanguage"));
	}

}
