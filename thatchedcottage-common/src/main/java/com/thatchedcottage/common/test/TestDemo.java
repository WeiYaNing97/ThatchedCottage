package com.thatchedcottage.common.test;

public class TestDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("123456789");
        int r=(int)(Math.random()*10);
        stringBuilder.insert(5,r);
        System.out.println(stringBuilder);
    }
}
