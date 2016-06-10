package com.tipwheal.dog;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Dog.<br>
 * contains age and hungary.
 *
 * @author Administrator
 */
public class Dog implements Serializable {
    private static final long serialVersionUID = 1L;
    private DogActions actions = new DogActions();
    private String name;
    private int sec;
    private int min;
    private int hour;
    private int day;
    private int hung;
    private double mood;
    private double weight;
    private double strength;
    private double clean;

    /**
     * constructor.
     */
    public Dog() {
        name = "Jack";
        hung = 100;
        mood = 20.0;
        weight = 20.0;
        strength = 20.0;
        clean = 20.0;
    }

    /**
     * show the state of the dog.
     *
     * @return a string to print.
     */
    public String show() {
        int age = this.getHour();
        int hung = this.getHung();
        String result = "";
        result += this.getName() + " is " + age + " hours old.\n";
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
        hung += 50;
        String result = "You feed " + this.getName() + ".";
        return result;
    }

    /**
     * wash.
     */
    public void wash() {
        clean += 1.0;
    }

    /**
     * getter for clean.
     *
     * @return clean.
     */
    public double getClean() {
        return clean;
    }

    /**
     * setter for clean.
     *
     * @param clean param.
     */
    public void setClean(double clean) {
        this.clean = clean;
    }

    /**
     * exercise and get stronger.
     */
    public void exercise() {
        strength += 1.0;
    }

    /**
     * just play without Playable.
     */
    public void play() {
        mood += 0.3;
    }

    /**
     * play with UseAble.
     *
     * @param u UseAble.
     */
    public void play(UseAble u) {
        if (u == null) {
            this.play();
            return;
        }
        Adder adder = (Adder) u.use(this);
        adder.use(this);
    }

    /**
     * grow.<br>
     * when grow, time counter runs and clean, mood, strength and hungary decline.<br>
     * for every minute, clean decline by 0.1 points.<br>
     * and every hour, mood decline half.<br>
     * and for strength, it decline 1.0 every day.
     */
    public void grow() {
        sec += 10;
        if (sec / 60 > min) {
            min = sec / 60;
            clean -= 0.1;
        }
        if (min / 60 > hour) {
            hour = min / 60;
            mood /= 2;
        }
        if (hour / 24 > day) {
            day = hour / 24;
            strength -= 1.0;
        }
        hung -= 1;
    }

    /**
     * getter for min.
     *
     * @return min.
     */
    public int getMin() {
        return min;
    }

    /**
     * getter for hour.
     *
     * @return hour.
     */
    public int getHour() {
        return hour;
    }

    /**
     * getter for day.
     *
     * @return day.
     */
    public int getDay() {
        return day;
    }

    /**
     * getter for hung.
     *
     * @return hung.
     */
    public int getHung() {
        return hung;
    }

    /**
     * setter for hung.
     *
     * @param hung param.
     */
    public void setHung(int hung) {
        this.hung = hung;
    }

    /**
     * getter for name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name.
     *
     * @param name param.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for mood.
     *
     * @return mood
     */
    public double getMood() {
        return mood;
    }

    /**
     * setter for mood.
     *
     * @param mood param.
     */
    public void setMood(double mood) {
        this.mood = mood;
    }

    /**
     * getter for strength.
     *
     * @return strength.
     */
    public double getStrength() {
        return strength;
    }

    /**
     * setter for strength.
     *
     * @param strength to be set.
     */
    public void setStrength(double strength) {
        this.strength = strength;
    }

    /**
     * getter for actions.
     *
     * @return actions.
     */
    public DogActions getActions() {
        return actions;
    }
}
