package com.jh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-1310:25
 **/
public class JvmTest {

    static JvmTest jvmTest = new JvmTest();

    public static void main(String[] args){

        System.out.println(12&0);

//        long i=0L;
//        while( i < 1000){
//            jvmTest.pushWork(i);
//        }
//        System.out.println("finish job");
    }

    public void pushWork(long id){
        Worker worker = new Worker("lishijia", id);
        worker.doWork();
    }

    static class Worker{
        private String name;
        private Long id;

        public Worker(String name, Long id) {
            this.name = name;
            this.id = id;
        }

        public void doWork(){
            System.out.println(this.name + "  do work");
        }
    }
}
