package com.itcast.threadTest;

public class ThreadTest3 {
    public static void main(String[] args) {
        Thread3 thread3 = new Thread3();
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = new Thread(thread3, "线程" + i);
            thread.start();
        }
    }
}
