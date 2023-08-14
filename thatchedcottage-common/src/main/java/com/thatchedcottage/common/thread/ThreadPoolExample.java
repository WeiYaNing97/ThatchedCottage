package com.thatchedcottage.common.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程测试类
 */
public class ThreadPoolExample {
    private static Integer NUMBER = 10;

    public static void main(String[] args) throws InterruptedException {
        String value ;
        //计时器
        CountDownLatch latch = new CountDownLatch(NUMBER);

        // 创建一个固定大小的线程池，线程池中最多有3个线程
        //ExecutorService executorService = Executors.newFixedThreadPool(int threads);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 提交任务给线程池
        for (int num = 0 ; num < NUMBER; num++) {
            value = num+"";
            executor.submit(new MyThread(value));
            executor.submit(new MyRunnable(value));
            latch.countDown();
        }

        latch.await();

        System.out.println("所有线程执行完毕，继续执行主线程");

        // 关闭线程池
        executor.shutdown();
    }
}
