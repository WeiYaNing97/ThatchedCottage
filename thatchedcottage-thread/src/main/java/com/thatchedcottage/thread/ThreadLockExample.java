package com.thatchedcottage.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100000);
        for (int num = 0; num < 1000000;num++){
            executorService.submit(new ThreadMy());
        }
        executorService.shutdown();
        System.out.println("结束");
    }
}
class ThreadMy extends Thread{
    public static int integer = 1000000;
    private static Lock bankLock = new ReentrantLock();
    @Override
    public void run() {
        bankLock.lock();
        try {
            this.integer = this.integer - 1;
        } finally {
            bankLock.unlock();
        }
        if (this.integer == 0){
            System.out.println("===================================================");
            System.err.println(this.integer);
            System.err.println("===================================================");
        }else {
            System.err.println(this.integer);
        }
    }
}