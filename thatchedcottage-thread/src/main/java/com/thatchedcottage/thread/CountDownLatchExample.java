package com.thatchedcottage.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 计时器测试类
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个CountDownLatch实例，计数器初始值为3
        CountDownLatch latch = new CountDownLatch(3);

        // 创建三个线程
        Thread t1 = new Thread(() -> {
            System.out.println("线程1开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行完毕");
            latch.countDown(); // 计数器减1
        });

        Thread t2 = new Thread(() -> {
            System.out.println("线程2开始执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行完毕");
            latch.countDown(); // 计数器减1
        });

        Thread t3 = new Thread(() -> {
            System.out.println("线程3开始执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3执行完毕");
            latch.countDown(); // 计数器减1
        });

        t1.start();
        t2.start();
        t3.start();

        latch.await(); // 等待计数器减到0

        System.out.println("所有线程执行完毕，继续执行主线程");
    }
}
