package com.itcast.threadTest;

public class ThreadTest2 {
    public static void main(String[] args) {
        Thread2 thread2 = new Thread2();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(thread2, "线程" + i);
            thread.start();
        }
    }
}
