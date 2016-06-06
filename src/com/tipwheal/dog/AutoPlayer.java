package com.tipwheal.dog;

import java.util.Random;

/**
 * AutoPlayer.
 * 
 * @author Administrator
 *
 */
public class AutoPlayer implements Runnable {
	private Dog dog;
	private static boolean on = true;

	/**
	 * contructor.
	 * 
	 * @param dog
	 */
	public AutoPlayer(Dog dog) {
		this.dog = dog;
	}

	/**
	 * implement method.
	 */
	public void run() {
		Random rnd = new Random();
		while (true) {
			if (on && rnd.nextInt(100) > 75) {
				new Action().randomShow(dog);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * turn on and turn off.
	 * 
	 * @param cmd
	 */
	public static void turn(String cmd) {
		switch (cmd) {
		case "-n":
			on = true;
			break;
		case "-f":
			on = false;
			break;
		}
	}

}
