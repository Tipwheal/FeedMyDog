package com.tipwheal.dog;

import java.util.ArrayList;

/**
 * ShoppingCenter.
 */
public class ShoppingCenter {
    private ArrayList<UseAble> list = new ArrayList<>();

    /**
     * get available UseAble list.
     */
    public void getAvailable() {
        StringBuilder sb = new StringBuilder("");
        for (UseAble u : list) {
            sb.append(u.toString());
            sb.append("\r\n");
        }
    }

    /**
     * buy an UseAble.
     *
     * @param index the index of UseAble in list.
     * @return a copy of UseAble.
     */
    public UseAble buy(int index) {
        if (index <= list.size())
            return list.get(index).copy();
        else
            return null;
    }

    /**
     * add.
     *
     * @param useAble
     */
    public void add(UseAble useAble) {
        list.add(useAble);
    }

    /**
     * delete.
     *
     * @param index
     */
    public void delete(int index) {
        if (index <= list.size())
            list.remove(index);
    }
}
