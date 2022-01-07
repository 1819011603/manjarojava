package com.ProxyTest;

public class CarImpl implements Car {
    @Override
    public Car buy() {
        return Car.super.buy();
    }

    @Override
    public void sail() {
        Car.super.sail();
    }
}
