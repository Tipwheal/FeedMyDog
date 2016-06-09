package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/9.
 */
public class Warmer implements Runnable {
    private Dog dog;

    /**
     * constructor.
     *
     * @param dog a dog.
     */
    public Warmer(Dog dog) {
        this.dog = dog;
    }


    /**
     * run.
     */
    public void run() {
        while (true) {
            if (dog.getHung() <= 50) {
                System.out.println(dog.getName() + " is hungary.");
            }
            if (dog.getMood() <= 10.0) {
                System.out.println(dog.getName() + " is unhappy.");
            }
            if (dog.getClean() <= 10.0) {
                System.out.println(dog.getName() + " wants to take a shower.");
            }
            if (dog.getStrength() <= 10.0) {
                System.out.println(dog.getName() + " is weak.");
            }
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
