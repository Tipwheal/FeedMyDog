package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public class BasketBall implements UseAble {
    private double size = 2.0;

    public void use(Dog dog) {
        dog.setHung(dog.getHung() - 5);
        dog.setClean(dog.getClean() - 5);
        dog.setStrength(dog.getStrength() + 0.5);
        dog.setMood(dog.getMood() + 1.3);
    }

    /**
     * store.
     *
     * @param room
     */
    public void store(Room room) {
        room.store(this);
    }

    /**
     * getter for size.
     *
     * @return
     */
    public double getSize() {
        return size;
    }

    /**
     * copy.
     *
     * @return
     */
    public UseAble copy() {
        return new BasketBall();
    }
}
