package com.jh.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-08-1311:53
 **/
public class LockTest {
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockTest a = new LockTest();
        a.startTest();
    }

    private void startTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.submit(new AThread(lock, "1"));
//        executorService.submit(new AThread(lock, "2"));

        executorService.submit(new BThread(lock, "1"));
        executorService.submit(new BThread(lock, "2"));
    }

    static class BThread implements Runnable {
        ReentrantLock lock;
        String name;

        public BThread(ReentrantLock lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {
            if (lock.tryLock()) {
                try {
                    System.out.println(name + " get lock");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(name + " not get lock");
            }
        }
    }

    static class AThread implements Runnable {
        ReentrantLock lock;
        String name;

        public AThread(ReentrantLock lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(name);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}
