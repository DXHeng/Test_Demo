package com.xio.study.thread;

        import java.util.concurrent.locks.Lock;
        import java.util.concurrent.locks.ReentrantLock;

public class MyTask {

    private Lock lock = new ReentrantLock(false);

    public void execute() {
        lock.lock();

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        lock.unlock();
    }
}