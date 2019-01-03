package com.itcast.thread;

public class ThreadTest5 extends Thread {
    public static void main(String[] args) {
        ThreadTest5 t = new ThreadTest5();
        t.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"主线程");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"子线程");
        }
    }
}
