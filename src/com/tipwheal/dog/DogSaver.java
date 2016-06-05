package com.tipwheal.dog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Dog Saver to save the Dog.
 * 
 * @author Administrator
 *
 */
public class DogSaver implements Runnable {
	private File file = new File("dog.ser");
	private Thread t = new Thread(this);
	private Dog dog;

	/**
	 * constructor.
	 * 
	 * @param dog
	 */
	public DogSaver(Dog dog) {
		this.dog = dog;
	}

	/**
	 * start.
	 */
	public void start() {
		t.start();
	}

	/**
	 * save.
	 * 
	 * @param dog
	 */
	public void save(Dog dog) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(dog);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * implemented from Runnable.
	 */
	public void run() {
		while (true) {
			dog.grow();
			save(dog);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
