package com.jh.design.factory.func;

import com.jh.design.factory.Benz;
import com.jh.design.factory.Bmw;
import com.jh.design.factory.Car;

public class BenzFactory implements CarFactory {

    public Car getCar() {
        return new Benz();
    }
}
