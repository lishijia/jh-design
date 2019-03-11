package com.jh.design.factory.func;

import com.jh.design.factory.Audi;
import com.jh.design.factory.Benz;
import com.jh.design.factory.Car;

public class AudiFactory implements CarFactory {

    public Car getCar() {
        return new Audi();
    }
}
