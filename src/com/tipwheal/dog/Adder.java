package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public class Adder implements UseAble {
    private Dog dog;
    private int hung;
    private double clean;
    private double strength;
    private double mood;

    /**
     * implemented method.
     *
     * @return null;
     */
    public StoreAble use(Dog dog) {
        dog.setHung(dog.getHung()+this.hung);
        dog.setClean(dog.getClean()+this.clean);
        dog.setStrength(dog.getStrength()+this.strength);
        dog.setMood(dog.getMood()+this.mood);
        return null;
    }

    /**
     * implemented from StoreAble.
     *
     * @param room the room to took up.
     */
    public void store(Room room) {
        room.store(0);
    }

    /**
     * constructor for Adder.
     *
     * @param hung     param.
     * @param clean    param.
     * @param strength param.
     * @param mood     param.
     * @param dog      param.
     */
    public Adder(int hung, double clean, double strength, double mood, Dog dog) {
        this.hung = hung;
        this.clean = clean;
        this.strength = strength;
        this.mood = mood;
        this.dog = dog;
    }
}
