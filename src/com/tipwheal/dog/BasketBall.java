package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public class BasketBall implements UseAble {
    public StoreAble use() {
        int hung = -5;
        double clean = -5.0;
        double strength = 0.5;
        double mood = 1.3;
        return new Adder(hung,clean,strength,mood);
    }
    public void store(Room room) {
        room.takeUp(2);
    }
}
