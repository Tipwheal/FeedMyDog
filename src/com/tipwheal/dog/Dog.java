package com.tipwheal.dog;

import java.io.Serializable;

/**
 * Dog.<br>
 * contains age and hungary.
 * 
 * @author Administrator
 *
 */
public class Dog implements Serializable {
	private static final long serialVersionUID = 1L;
	private int sec;
	private int min;
	private int hour;
	private int day;
	private int hung = 100;

	public void feed() {
		hung += 50;
	}

	public void grow() {
		sec++;
		hung--;
		min = sec / 60;
		hour = min / 60;
		day = hour / 24;
	}

	public int getHour() {
		return hour;
	}

	public int getDay() {
		return day;
	}

	public int getHung() {
		return hung;
	}
}
