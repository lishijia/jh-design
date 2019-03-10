package com.jh.design.proxy.custom;

import com.jh.design.proxy.JohnPerson;
import com.jh.design.proxy.Person;

public class Test {

    public static void main(String args[]) throws Exception {
        /**
         * 原理：
         * 1. 动态代理AgentProxy拿到代理对象
         * 2. JDK动态生成一个代理类（Proxy$），这个类实现动态代理对象所实现的接口
         * 3. 把动态代理对象的引用也拿到（在新生成的类中）
         * 4. 编辑运行
         */
        Person person = (Person)new JhAgentProxy().getInstance(new JohnPerson());
        person.findHouse();
    }

}
