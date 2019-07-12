package com.jh.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-07-10 17:54
 **/
public class ThreadMainTest {

    static class B implements Runnable {
        private Data data;

        public B(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            while(true){
                Random random = new Random();
                try {
                    int sleepTime = random.nextInt(10);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                data.plusOne();
            }
        }

        /**
         * 错误的用法
         */
        private synchronized void  plusOne(){
            this.data.setDint(this.data.getDint() + 1);
            System.out.println(Thread.currentThread().getId() + " := " + data.getDint());
        }
    }

    public static void main(String args[]){
        ThreadMainTest.Data data = new ThreadMainTest.Data(1);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new B(data));
        executorService.submit(new B(data));
        executorService.submit(new B(data));
    }

    public static class Data{
        public int dint = 1;

        public Data(int dint) {
            this.dint = dint;
        }

        public void setDint(int dint) {
            this.dint = dint;
        }

        public int getDint() {
            return dint;
        }
        private synchronized void  plusOne(){
            this.setDint(this.getDint() + 1);
            System.out.println(Thread.currentThread().getId() + " := " + getDint());
        }
    }

}
