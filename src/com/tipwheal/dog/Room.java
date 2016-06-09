package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public class Room {
    private double space = 100.0;

    public Room(Dog dog) {

    }

    public void takeUp(double d) {
        space -= d;
    }

    public void takeUp(int i) {
        space -= i;
    }
}
