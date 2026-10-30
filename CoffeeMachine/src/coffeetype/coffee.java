package coffeetype;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import logging.AssignmentLogger;

public abstract class coffee {
	//attributes
	protected String name;
	protected int prepTime;
	protected String soundFiles;
	/**
	 * Constructor for coffee
	 * @param name
	 * @param prepTime
	 * @param soundFiles
	 */
	public coffee(String name, int prepTime, String soundFiles) {
		AssignmentLogger.logConstructor(this);
		this.name = name;
		this.prepTime = prepTime;
		this.soundFiles = soundFiles;
	}
	//getter
	public String getName() {
		AssignmentLogger.logConstructor(this);
		return name;
	}

	public int getPrepTime() {
		AssignmentLogger.logConstructor(this);
		return prepTime;
	}

	public String getSoundFiles() {
		AssignmentLogger.logConstructor(this);
		return soundFiles;
	}
	//setter
	public void prepTime(int prepTime) {
		AssignmentLogger.logConstructor(this);
		this.prepTime = prepTime;
	}
	public void name(String name) {
		AssignmentLogger.logConstructor(this);
		this.name = name;
	}
	public void soundFiles(String soundFiles) {
		AssignmentLogger.logConstructor(this);
		this.soundFiles = soundFiles;
	}
	//abstract method
	public abstract void preprare();

	//method to play sound
	/**
	 * This method is used to play the sound of the coffee
	 * @method playSound
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void playSound() {
		AssignmentLogger.logMethodEntry(this);
		System.out.println("Playing sound files: " + soundFiles);
		try {
		File soundFile = new File(soundFiles);
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
		try {
				Thread.sleep(3000);
			} 
            catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            clip.stop();
		}
		
		catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
		e.printStackTrace();
		}
		AssignmentLogger.logMethodExit(this);
	}
	

	

}
