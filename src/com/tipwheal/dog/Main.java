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
		DogSaver saver = new DogSaver(dog);
		Thread auto = new Thread(new AutoPlayer(dog));
		auto.start();
		saver.start();
		while (true) {
			action.doAction(IOHelper.getInput(), dog);
		}
	}
}
