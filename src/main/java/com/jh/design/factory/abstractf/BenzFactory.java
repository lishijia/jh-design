package com.jh.design.factory.abstractf;

import com.jh.design.factory.Benz;
import com.jh.design.factory.Car;
import com.jh.design.factory.func.CarFactory;

public class BenzFactory implements CarFactory {

    public Car getCar() {
        return new Benz();
    }
}
