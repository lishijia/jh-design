package com.jh.design.delegate;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-11 15:44
 **/
public class SimpleExecutor implements IExecutor {

    @Override
    public Object query() {
        System.out.println("data from simple executor");
        return null;
    }
}
