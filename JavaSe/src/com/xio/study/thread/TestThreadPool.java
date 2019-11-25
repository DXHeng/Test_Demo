package com.xio.study.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
//        ReentrantLock
        executorService.submit(new TestThread());

        /**
         * int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory
         */
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                5,
//                10,
//                8,
//                TimeUnit.SECONDS,
//                new TestThread()
//        );

//        TestThread testThread = new TestThread();
//        new Thread(testThread).start();
    }

}

class TestThread implements Runnable {

    private int i = 1;

    @Override
    public void run() {
        while (i < 100) {
            System.out.println(Thread.currentThread().getName() + " : " + i++);
        }
    }

}