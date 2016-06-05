package com.tipwheal.dog;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class DogActions implements Serializable {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> action = new ArrayList<>();

	public static String get(int i) {
		return action.get(i);
	}

	public static int size() {
		return action.size();
	}

	@SuppressWarnings("unchecked")
	public static void add(String s) {
		action.add(s);
		ObjectIO.saveObject("action", (Object) action);
		action = (ArrayList<String>) ObjectIO.readObject("action");
	}

	@SuppressWarnings("unchecked")
	public static void delete(String s) {
		action.remove(s);
		ObjectIO.saveObject("action", (Object) action);
		action = (ArrayList<String>) ObjectIO.readObject("action");
	}
}
