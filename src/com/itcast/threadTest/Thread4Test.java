package com.itcast.threadTest;

public class Thread4Test {
    public static void main(String[] args) {
        Thread4 t1 = new Thread4(20);
        t1.setName("张某");
        Thread4 t2 = new Thread4(10);
        t2.setName("李某");
        Thread4 t3 = new Thread4(5);
        t3.setName("赵某");
        t1.start();
        t2.start();
        t3.start();
    }
}
