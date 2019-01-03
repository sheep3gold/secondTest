package com.itcast.thread;

public class ThreadTest4 {

    public static void main(String[] args) {
       /* Thread4 thread4 = new Thread4();
        for (int i = 0; i < 10; i++) {
            new Thread(thread4, "线程"+i).start();
        }*/
        Thread4 thread4 = new Thread4();
        for (int i = 1; i <= 10; i++) {
            new Thread(thread4, "p" + i).start();
        }

    }
}
