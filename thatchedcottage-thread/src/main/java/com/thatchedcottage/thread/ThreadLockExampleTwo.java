package com.thatchedcottage.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockExampleTwo {
    private static Integer integer = 10000000;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        Test test = new Test(integer);
        for (int num = 0; num < 10000000; num++) {
            executorService.submit(()-> test.getValue());
        }
        executorService.shutdown();
        System.out.println("结束");
    }
}

class Test {
    private static Lock lock =new ReentrantLock();
    private static Integer value;

    public Test(Integer value){
        this.value = value;
    }

    public synchronized Integer getValue(){
        /*lock.lock();
        try {
            value = value-1;
            if (value == 0){
                System.out.println("======================================");
                System.out.println(value);
                System.out.println("======================================");
            }else {
                System.err.println(value);
            }
        }finally {
            lock.unlock();
        }*/
        value = value-1;
        if (value == 0){
            System.out.println("======================================");
            System.out.println(value);
            System.out.println("======================================");
        }else {
            System.err.println(value);
        }
        return value;
    }

}