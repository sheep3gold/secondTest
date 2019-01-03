package com.itcast.threadTest;

public class Thread5Test {
    public static void main(String[] args) {
        /*Thread5 t1 = new Thread5();
        t1.setName("线程1");
        t1.setPriority(10);
        Thread5 t2 = new Thread5();
        t2.setName("线程2");
        t2.setPriority(6);
        t1.start();
        t2.start();*/
        Thread5 thread5 = new Thread5();
        Thread t1 = new Thread(thread5, "线程1");
        Thread t2 = new Thread(thread5, "线程2");
        t1.setPriority(10);
        t2.setPriority(6);
        t1.start();
        t2.start();
    }
}
