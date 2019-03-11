package com.jh.design.factory.abstractf;

import com.jh.design.factory.Car;

public abstract class AbstractCarFactory {

    protected abstract Object getCard();

    public Car getCar(String carName) {
        if ("BMW".equalsIgnoreCase(carName)) {
            return new BmwFactory().getCar();
        } else if ("AUDI".equalsIgnoreCase(carName)) {
            return new AudiFactory().getCar();
        } else if ("BENZ".equalsIgnoreCase(carName)) {
            return new BenzFactory().getCar();
        }

        return null;
    }


}
