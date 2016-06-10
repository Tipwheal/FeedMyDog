package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public class Room {
    private double space = 100.0;
    private Dog dog;

    public Room(Dog dog) {
        this.dog = dog;
    }

    public boolean store(double d) {
        if (d <= this.space) {
            space -= d;
            return true;
        } else {
            return false;
        }
    }

    public void store(int i) {
        this.store((double) i);
    }
}
