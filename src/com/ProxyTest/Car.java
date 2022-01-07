package com.ProxyTest;

public interface Car {
    default Car buy(){
        System.out.println("buy car");
        return null;
    }

    default void sail(){
        System.out.println("sail car");
    }


}
