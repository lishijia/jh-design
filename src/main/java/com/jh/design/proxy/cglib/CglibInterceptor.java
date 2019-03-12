package com.jh.design.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-1210:37
 **/
public class CglibInterceptor implements MethodInterceptor {

    public Object getInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("this is the cglib intercept before invoke the super class method");
        methodProxy.invokeSuper(o, objects);
        System.out.println("this is the cglib intercept after invoke the super class method");
        return null;
    }
}
