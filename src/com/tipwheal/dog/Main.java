package com.tipwheal.dog;

import com.tipwheal.visual.*;
/**
 * Main part of this game.
 *
 * @author Administrator
 */
public class Main {
    /**
     * enter the game.
     *
     * @param args
     */
    public static void main(String[] args) {
        Dog dog = new DogLoader().load();
        Temp.dog = dog;
        Action action = new Action();
        DogSaver saver = new DogSaver(dog);
        Thread auto = new Thread(new AutoPlayer(dog));
        Thread warn = new Thread(new Warmer(dog));
        MainFrame frame = new MainFrame(dog);
        auto.start();
        warn.start();
        saver.start();
        while (true) {
            action.doAction(IOHelper.getInput(), dog);
        }
    }
}
