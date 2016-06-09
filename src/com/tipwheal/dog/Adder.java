package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public class Adder implements UseAble {
    public StoreAble use() {
        return null;
    }

    public void store(Room room) {
        room.takeUp(0);
    }

    public Adder(int hung, double clean, double strength, double mood) {

    }
}
