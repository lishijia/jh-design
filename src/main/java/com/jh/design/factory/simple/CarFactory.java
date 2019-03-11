package com.jh.design.factory.simple;

import com.jh.design.factory.Audi;
import com.jh.design.factory.Benz;
import com.jh.design.factory.Bmw;
import com.jh.design.factory.Car;

/**
 * 简单工厂
 */
public class CarFactory {

    public static Car getCar(String carName) {

        if ("BMW".equalsIgnoreCase(carName)) {
            return new Bmw();
        } else if ("AUDI".equalsIgnoreCase(carName)) {
            return new Audi();
        } else if ("BENZ".equalsIgnoreCase(carName)) {
            return new Benz();
        }
        return null;
    }

}
