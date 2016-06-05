package com.tipwheal.dog;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Dog loader to load the dog.
 * 
 * @author Administrator
 *
 */
public class DogLoader {
	File file = new File("dog.ser");

	/**
	 * load the dog.
	 * 
	 * @return
	 */
	public Dog load() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new Dog();
		}
		Dog dog = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			dog = (Dog) is.readObject();
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dog;
	}
}
