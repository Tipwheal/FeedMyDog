package com.tipwheal.dog;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * DogActions.
 *
 * @author Administrator
 */
public class DogActions implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ArrayList<String> action = new ArrayList<>();

    /**
     *
     */
    public DogActions() {
        load();
        save();
    }

    /**
     * @param i
     * @return
     */
    public String get(int i) {
        return action.get(i);
    }

    /**
     * @return
     */
    public int size() {
        return action.size();
    }

    /**
     * add an action.
     *
     * @param s
     */
    public void add(String s) {
        action.add(s);
    }

    /**
     * delete an action.
     *
     * @param s
     */
    public void delete(String s) {
        action.remove(s);
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public void load() {
        action = (ArrayList<String>) IOHelper.readObject("action.ser");
        if (action == null) {
            action = new ArrayList<>();
        }
    }

    /**
     *
     */
    public void save() {
        IOHelper.saveObject("action.ser", action);
    }
}
