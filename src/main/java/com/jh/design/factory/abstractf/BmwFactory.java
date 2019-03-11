package com.jh.design.factory.abstractf;

import com.jh.design.factory.Bmw;
import com.jh.design.factory.Car;
import com.jh.design.factory.func.CarFactory;

public class BmwFactory implements CarFactory {

    public Car getCar() {
        return new Bmw();
    }
}
