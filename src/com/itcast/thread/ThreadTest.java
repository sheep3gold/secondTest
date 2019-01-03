package com.itcast.thread;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread t1 = new Thread(threadDemo);
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程执行");
        }

    }
}
