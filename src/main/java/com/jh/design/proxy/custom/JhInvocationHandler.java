package com.jh.design.proxy.custom;

import java.lang.reflect.Method;

public interface JhInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
