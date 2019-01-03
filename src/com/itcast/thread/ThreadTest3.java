package com.itcast.thread;

public class ThreadTest3 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("线程1");
            }
        }).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程");
        }
    }
}
