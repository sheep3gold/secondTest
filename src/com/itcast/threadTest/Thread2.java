package com.itcast.threadTest;

public class Thread2 implements Runnable {

    private int num=1;


    @Override
    public void run() {
        try {
            cross();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void cross() throws InterruptedException {
        Thread.sleep(50);
        System.out.println(Thread.currentThread().getName() + "第" + num + "个通过");
        num++;
    }
}
