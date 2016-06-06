package com.tipwheal.dog;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * DogActions.
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public class DogActions implements Serializable {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> action = new ArrayList<>();

	/**
	 * initialize.
	 */
	static {
		action = (ArrayList<String>) IOHelper.readObject("action");
	}

	public String get(int i) {
		return action.get(i);
	}

	public int size() {
		return action.size();
	}

	/**
	 * add an action.
	 * 
	 * @param s
	 */
	public void add(String s) {
		action.add(s);
		IOHelper.saveObject("action", (Object) action);
		action = (ArrayList<String>) IOHelper.readObject("action");
	}

	/**
	 * delete an action.
	 * 
	 * @param s
	 */
	public void delete(String s) {
		action.remove(s);
		IOHelper.saveObject("action", (Object) action);
		action = (ArrayList<String>) IOHelper.readObject("action");
	}
}
