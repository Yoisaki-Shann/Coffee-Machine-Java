package Main;

import logging.AssignmentLogger;
import menu.*;
import exceptions.*;


public class main {
	
	/**
	 * This is the main method of the program
	 * It is the entry point of the program
	 * It is the main method of the program
	 * catch exception if 2 types of exception occur
	 * @param args
	 * @throws InvalidCoffeeException
	 * @throws InvalidLanguageException
	 */
	public static boolean isRunning = true;
	public static void main(String[] args) {

		AssignmentLogger.logStaticMethodEntry();
		
		while(isRunning){
			try {
				//this display language menu 
				Menu.displayLanguageMenu();
			}
			catch (InvalidCoffeeException e) {
			AssignmentLogger.logCatchException(e);
			System.out.println(e.getMessage());
			}
			catch (InvalidLanguageException e) {
			AssignmentLogger.logCatchException(e);
			System.out.println(e.getMessage());
			}
		}
		AssignmentLogger.logStaticMethodExit();
	}

}
