package coffeetype;

import logging.AssignmentLogger;
import menu.Menu;
import java.util.ResourceBundle;

public class latte extends coffee {

	/**
	 * Constructor for latte
	 * 
	 */
	public latte() {
		super("Latte", 4500, "Sound/Latte.wav");
		AssignmentLogger.logConstructor(this);
	}

	/**
	 * This method is used to prepare the coffee
	 * 
	 * @method preprare
	 */
	public void preprare() {
		AssignmentLogger.logMethodEntry(this);
		playSound();
		new Thread(() -> {
			try {
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