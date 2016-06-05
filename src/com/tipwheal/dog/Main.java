package com.tipwheal.dog;

/**
 * Main part of this game.
 * 
 * @author Administrator
 *
 */
public class Main {
	/**
	 * enter the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog = new DogLoader().load();
		Action action = new Action();
		IOHelper helper = new IOHelper();
		DogSaver saver = new DogSaver(dog);
		saver.start();
		while (true) {
			action.doAction(helper.getInput(), dog);
		}
	}
}
