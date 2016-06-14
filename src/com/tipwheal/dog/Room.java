package com.tipwheal.dog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/10.
 */
public class Room {
    private double space = 100.0;
    private Dog dog;
    private ArrayList<StoreAble> buffs = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param dog
     */
    public Room(Dog dog) {
        this.dog = dog;
    }

    /**
     * store.
     *
     * @param storeAble
     * @return
     */
    public boolean store(StoreAble storeAble) {
        if (storeAble.getSize() <= this.space) {
            space -= storeAble.getSize();
            buffs.add(storeAble);
            return true;
        } else {
            return false;
        }
    }

}
