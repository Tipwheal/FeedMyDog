package com.tipwheal.visual;

import com.tipwheal.dog.Dog;

/**
 * Temp is a place to save something that can use but should pass from one class to another.
 */
public abstract class Temp {
    public static String str;
    public static Dog dog;

    public static void ChangeWindow(NameRefactor n) {
        n.dispose();
        new MainFrame(Temp.dog);
    }
}
