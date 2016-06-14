package com.tipwheal.dog;

/**
 * Created by Administrator on 2016/6/10.
 */
public interface UseAble extends StoreAble{
    public void use(Dog dog);

    public UseAble copy();
}
