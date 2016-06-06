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
	private DogActions actions = new DogActions();
	private HashMap<String, String> sFea = new HashMap<>();
	private HashMap<String, Integer> iFea = new HashMap<>();
	private HashMap<String, Double> dFea = new HashMap<>();

	/**
	 * constructor.
	 */
	public Dog() {
		sFea.put("name", "Jack");
		iFea.put("sec", 0);
		iFea.put("min", 0);
		iFea.put("hour", 0);
		iFea.put("day", 0);
		iFea.put("hung", 100);
		dFea.put("mood", 5.0);
		dFea.put("weight", 20.0);
		dFea.put("strength", 20.0);
		dFea.put("clearity", 20.0);
	}

	/**
	 * show the state of the dog.
	 * 
	 * @return
	 */
	public String show() {
		int age = this.getHour();
		int hung = this.getHung();
		String result = "";
		result += this.getName() + " is " + age + " hours old.";
		result += "equals to " + this.getMin() + " minutes.";
		if (hung < 50) {
			result += "It's hungary.";
		} else if (hung > 90) {
			result += "It's not hungary at all.";
		}
		return result;
	}

	/**
	 * feed.
	 */
	public String feed() {
		iFea.replace("hung", iFea.get("hung") + 50);
		String result = "You feed " + this.getName() + ".";
		return result;
	}

	public DogActions getAction() {
		return actions;
	}

	/**
	 * wash.
	 */
	public void wash() {
		dFea.replace("clearity", dFea.get("clearity") + 1.0);
	}

	/**
	 * play.
	 */
	public void play() {
		dFea.replace("mood", dFea.get("mood") + 0.3);
	}

	/**
	 * grow.
	 */
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

	public double getMood() {
		return dFea.get("mood");
	}

	public double getStrength() {
		return dFea.get("strength");
	}
}
