package com.jh.design.proxy.custom;

import java.lang.reflect.Method;

public class JhAgentProxy implements JhInvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        try {
            return JhProxy.newProxyInstance(new JhClassLoader(), target.getClass().getInterfaces(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介开始找房子");
        return method.invoke(target, args);
    }
}
