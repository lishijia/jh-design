package com.jh.jvm;

public class YoungGCTest {

    public static void main(String args[]){

        System.out.println(12);
        byte[] barry1 = new byte[1024 * 1024];

        barry1 = new byte[1024 * 1024];

        barry1 = new byte[1024 * 1024];

        barry1 = null;

        byte[] barry2 = new byte[1024 * 1024 * 2];
        System.out.println(12);

    }

}
