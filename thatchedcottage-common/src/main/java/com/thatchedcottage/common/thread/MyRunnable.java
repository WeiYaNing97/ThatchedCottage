package com.thatchedcottage.common.thread;

/**
 * 实现 Runnable 的线程测试类
 */
public class MyRunnable implements Runnable {

    private String values;

    public MyRunnable(String values) {
        this.values = values;
    }
    public MyRunnable() {
    }
    @Override
    public void run() {
        Thread.currentThread().setName(values);
        System.err.println("开启了 Runnable 线程: " + Thread.currentThread().getName());
    }
}
