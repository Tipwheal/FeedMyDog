package com.tipwheal.dog;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Dog.<br>
 * contains age and hungary.
 * 
 * @author Administrator
 *
 */
public class Dog implements Serializable {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> sFea = new HashMap<>();
	private HashMap<String, Integer> iFea = new HashMap<>();
	private HashMap<String, Double> dFea = new HashMap<>();

	public Dog() {
		sFea.put("name", "Jack");
		iFea.put("sec", 0);
		iFea.put("min", 0);
		iFea.put("hour", 0);
		iFea.put("day", 0);
		iFea.put("hung", 100);
	}

	public void feed() {
		iFea.replace("hung", iFea.get("hung") + 50);
	}

	public void grow() {
		iFea.replace("sec", iFea.get("sec") + 10);
		iFea.replace("min", iFea.get("sec") / 60);
		iFea.replace("hour", iFea.get("min") / 60);
		iFea.replace("day", iFea.get("hour") / 24);
		iFea.replace("hung", iFea.get("hung") - 1);
	}

	public int getMin() {
		return iFea.get("min");
	}

	public int getHour() {
		return iFea.get("hour");
	}

	public int getDay() {
		return iFea.get("day");
	}

	public int getHung() {
		return iFea.get("hung");
	}

	public String getName() {
		return sFea.get("name");
	}

	public void setName(String name) {
		sFea.replace("name", name);
	}
}
