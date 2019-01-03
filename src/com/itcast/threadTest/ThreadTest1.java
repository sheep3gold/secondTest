package com.itcast.threadTest;

import java.util.ArrayList;
import java.util.Random;

public class ThreadTest1 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(100)+1;

        Thread1 thread1 = new Thread1(n);
        for (int i = n; i > 0; i++) {
//            Thread1 t = new Thread1("线程" + i,i);
            Thread t = new Thread(thread1);
            t.start();
        }



    }
}
