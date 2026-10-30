package coffeetype;

import logging.AssignmentLogger;
import menu.Menu;
import java.util.ResourceBundle;

public class americano extends coffee {

	/**
	 * Constructor for americano
	 * 
	 */
	public americano() {
		super("Americano", 6000, "Sound/Americano.wav");
		AssignmentLogger.logConstructor(this);
	}

	/**
	 * This method is used to prepare the coffee
	 * 
	 * @method preprare
	 * 
	 */
	public void preprare() {
		AssignmentLogger.logMethodEntry(this);
		playSound();
		new Thread(() -> {
			try {
				// prints the time taken to prepare the coffee
				System.out.println("Preparing");
				for (int i = 0; i < prepTime / 1000; i++) {
					System.out.print(".");
					Thread.sleep(1000);
				}
				System.out.println("\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// display the coffee is ready
			ResourceBundle bundle = ResourceBundle.getBundle("trans.trans", Menu.locale);
			System.out.println(bundle.getString("Your") + " " + bundle.getString(name) + " " + bundle.getString("isReady"));
		}).start();

		AssignmentLogger.logMethodExit(this);
	}

}
