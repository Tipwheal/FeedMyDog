package com.tipwheal.dog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class ObjectIO {
	public static void saveObject(String fileName, Object object) {
		File file = new File(fileName);
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(object);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object readObject(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		ObjectInputStream is;
		Object object = null;
		try {
			is = new ObjectInputStream(new FileInputStream(file));
			object = is.readObject();
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return object;
	}
}
