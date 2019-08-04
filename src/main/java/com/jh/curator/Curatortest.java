package com.jh.curator;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

public class Curatortest {

    public static void main(String[] args) throws Exception {

        InterProcessMutex lock = new InterProcessMutex(null, null);
        try {
            if(lock.acquire(5, TimeUnit.SECONDS)){

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.release();
        }

    }

}
