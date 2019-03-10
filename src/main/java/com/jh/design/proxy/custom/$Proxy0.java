package com.jh.design.proxy.custom;

import java.lang.reflect.Method;

/**
 * 动态生成的代理类
 */
public final class $Proxy0 implements com.jh.design.proxy.Person {
    protected JhInvocationHandler h;

    public $Proxy0(JhInvocationHandler h) {
        this.h = h;
    }

    public void findHouse() {
        try {
            Method m = com.jh.design.proxy.Person.class.getMethod("findHouse", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}