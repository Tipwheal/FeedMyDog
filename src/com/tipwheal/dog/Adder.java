package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public class Adder implements UseAble {
    private int hung;
    private double clean;
    private double strength;
    private double mood;
    private double size;

    /**
     * implemented method.
     *
     * @return null;
     */
    public void use(Dog dog) {
        dog.setHung(dog.getHung() + this.hung);
        dog.setClean(dog.getClean() + this.clean);
        dog.setStrength(dog.getStrength() + this.strength);
        dog.setMood(dog.getMood() + this.mood);
    }

    /**
     * implemented from StoreAble.
     *
     * @param room the room to took up.
     */
    public void store(Room room) {
        room.store(this);
    }

    /**
     * constructor for Adder.
     *
     * @param hung     param.
     * @param clean    param.
     * @param strength param.
     * @param mood     param.
     */
    public Adder(int hung, double clean, double strength, double mood) {
        this.hung = hung;
        this.clean = clean;
        this.strength = strength;
        this.mood = mood;
    }

    /**
     * override method
     *
     * @return
     */
    public double getSize() {
        return 0.0;
    }

    /**
     * override method.
     *
     * @return
     */
    public UseAble copy() {
        return new Adder(hung, clean, strength, mood);
    }
}
