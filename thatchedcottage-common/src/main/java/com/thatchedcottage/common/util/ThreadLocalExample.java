package com.thatchedcottage.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ThreadLocalExample {

    public static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0; // 设置初始值为0
        }
    };

    public static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置初始值为0
        }
    };


    public static void main(String[] args) throws InterruptedException {
        // 创建两个线程
        Thread t1 = new Thread(() -> {
            // 设置线程1的变量值为10
            integerThreadLocal.set(10);
            try {
                Thread.sleep(1000); // 睡眠1秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1的变量值：" + integerThreadLocal.get() + "" + simpleDateFormatThreadLocal.get().format(new Date())); // 获取线程1的变量值
            integerThreadLocal.remove(); // 移除线程1的变量副本
            simpleDateFormatThreadLocal.remove();
        });

        Thread t2 = new Thread(() -> {
            // 设置线程2的变量值为20
            integerThreadLocal.set(20);
            try {
                Thread.sleep(500); // 睡眠0.5秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2的变量值：" + integerThreadLocal.get() + "" + simpleDateFormatThreadLocal.get().format(new Date())); // 获取线程2的变量值
            integerThreadLocal.remove(); // 移除线程2的变量副本
            simpleDateFormatThreadLocal.remove();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
