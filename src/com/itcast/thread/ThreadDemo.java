package com.itcast.thread;

public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程执行");
        }
    }
}
