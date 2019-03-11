package com.jh.design.delegate;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-11 15:45
 **/
public class DelegateTest {

    public static void main(String args[]){

        IExecutor executor = new SimpleExecutor();
        //executor.query();

        CachingExecutor cachingExecutor = new CachingExecutor(executor, false);
        cachingExecutor.query();
    }

}
