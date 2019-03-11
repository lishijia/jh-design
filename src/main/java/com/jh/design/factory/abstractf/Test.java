package com.jh.design.factory.abstractf;

public class Test {

    public static void main(String args[]) {

        DefaultCarFactory factory = new DefaultCarFactory();
        System.out.println(factory.getCar("BMW"));
        System.out.println(factory.getCar("AUDI"));
        System.out.println(factory.getCar("BENZ"));

    }

}
