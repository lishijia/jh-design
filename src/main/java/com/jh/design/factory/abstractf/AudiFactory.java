package com.jh.design.factory.abstractf;

import com.jh.design.factory.Audi;
import com.jh.design.factory.Car;
import com.jh.design.factory.func.CarFactory;

public class AudiFactory implements CarFactory {

    public Car getCar() {
        return new Audi();
    }
}
