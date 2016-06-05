package com.tipwheal.dog;

import java.util.Random;

public class AutoPlayer implements Runnable {
	private Dog dog;

	public AutoPlayer(Dog dog) {
		this.dog = dog;
	}

	public void run() {
		Random rnd = new Random();
		while (true) {
			if (rnd.nextInt(100) > 75) {
				new Action().randomShow(dog);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
