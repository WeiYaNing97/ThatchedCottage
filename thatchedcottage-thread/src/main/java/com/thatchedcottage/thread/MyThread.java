package com.thatchedcottage.thread;

/**
 * 继承 Thread 的线程测试类
 */
public class MyThread extends Thread {
    private String values;
    public MyThread(String values) {
        this.values = values;
    }
    public MyThread() {
    }
    @Override
    public void run() {
        Thread.currentThread().setName(values);
        Thread.currentThread().setPriority(10);
        System.err.println("开启了 Thread 线程: " + Thread.currentThread().getName() );
    }
}
