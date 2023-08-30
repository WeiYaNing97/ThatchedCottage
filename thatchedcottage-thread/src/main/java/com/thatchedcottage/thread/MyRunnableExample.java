package com.thatchedcottage.thread;

/**
 * ()->  Runnable 的线程测试类
 */
public class MyRunnableExample {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.err.println("运行run ()-> 方法 ");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
