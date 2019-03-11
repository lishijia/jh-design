package com.jh.design.single;

/**
 * @program:
 * @description: 单例模式
 * @author: lishijia
 * @create: 2019-03-11 11:50
 **/
public class Single1 {

    private Single1(){

    }

    private static class Single1Class{
        private final static Single1 s1 = new Single1();
    }

    public static Single1 getInstance(){
        return Single1Class.s1;
    }


}
