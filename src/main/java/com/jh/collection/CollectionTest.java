package com.jh.collection;

import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-12 14:44
 **/
public class CollectionTest {

    public static void main(String args[]) throws InterruptedException {
        testTreeSet();
        testQueue();
    }


    private static void testQueue() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new ProduceApple(blockingQueue));
        executorService.submit(new EatApple(blockingQueue));
    }

    static class ProduceApple implements Runnable {
        BlockingQueue<String> blockingQueue;

        public ProduceApple(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                Random random = new Random();
                int randomInt = random.nextInt(10);
                String appleName = "apple" + randomInt;
                System.out.println("生产苹果 " + appleName);
                blockingQueue.add(appleName);
                try {
                    Thread.sleep(randomInt * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class EatApple implements Runnable {
        BlockingQueue<String> blockingQueue;

        public EatApple(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String appleName = blockingQueue.take();
                    System.out.println("吃苹果 ：= " + appleName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
    }


}
