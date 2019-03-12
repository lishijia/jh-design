package com.jh.design.proxy.cglib;

/**
 * 通过cglib实现动态代理
 * 1. cglib的动态代理与JDK的动态代理实现有差别
 * 2. cglib是不需要接口的方式来实现
 * 3. cglib是依据目标对象，针对目标对象生成一个期子类，然后编译加载执行
 */
public class CglibTest {

    public static void main(String args[]){

        Person person = (Person) new CglibInterceptor().getInstance(Person.class);
        person.findHouse();
    }


}
