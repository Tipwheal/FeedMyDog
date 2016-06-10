package com.tipwheal.visual;

import com.tipwheal.dog.Dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public abstract class Temp {
    public static String str;
    public static Dog dog;

    public static void ChangeWindow(NameRefactor n) {
        n.dispose();
        new MainFrame(Temp.dog);
    }
}
