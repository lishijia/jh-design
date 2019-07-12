package com.jh.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-11 15:16
 **/
public class FutureWithCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        futureTest();
        countDownLatchTest();
    }

    private static void countDownLatchTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new CountDownThread(start, latch, "worker" + i));
        }

        System.out.println("预备");
        start.countDown(); // 相当于从Count里面扣减1
        System.out.println("准备开始工作");

        latch.await();
        System.out.println("all work finish");

        executorService.shutdown();
    }

    static class CountDownThread implements Runnable {

        CountDownLatch start;
        CountDownLatch latch;
        String workName;

        public CountDownThread(CountDownLatch start, CountDownLatch latch, String workName) {
            this.start = start;
            this.latch = latch;
            this.workName = workName;
        }

        @Override
        public void run() {
            try {
                start.await();
                this.doWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }

        private void doWork() {
            Random random = new Random();
            try {
                int sleepTime = random.nextInt(10);
                Thread.sleep(sleepTime*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(workName);
        }
    }

    public static void futureTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("开始执行 " + Thread.currentThread().getId() + "号线程");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getId() + "号线程 执行完准备返回");
                return 1;
            }
        });
        Future future1 = executorService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("开始执行 " + Thread.currentThread().getId() + "号线程");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getId() + "号线程 执行完准备返回");
                return 2;
            }
        });
        System.out.println("已经提交线程");
        System.out.println("future 返回结果 ：= " + future.cancel(true));
        System.out.println("future1 返回结果 ：= " + future1.get());

        FutureTask futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("通过 Thread 执行的 FutureTask");
                return 11;
            }
        });
        Thread t1 = new Thread(futureTask);
        t1.start();

        System.out.println("thread futureTask return result:=" + futureTask.get());
        executorService.shutdown();
    }


}
