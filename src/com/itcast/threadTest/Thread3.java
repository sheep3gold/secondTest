package com.itcast.threadTest;

import java.util.Random;

public class Thread3 implements Runnable {

    private int temperature;
    private int moisture;
    private int wind;

    Random random = new Random();
    public Thread3() {

    }

    @Override
    public void run() {
        read();
    }

    public synchronized void read() {
        try {
            Thread.sleep(5000);
            temperature = random.nextInt(50)+1;
            moisture = random.nextInt(50)+1;
            wind = random.nextInt(50)+1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+temperature
        +" "+moisture+" "+wind);

    }
}
