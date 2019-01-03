package com.itcast.threadTest;

import java.util.ArrayList;

public class Thread1 implements Runnable {
//    private String name;
    private int num;
    public Thread1(int num){
//        this.name = name;
        this.num = num;
    }
    static ArrayList<String> list = new ArrayList<>();
    @Override
    public void run() {
        synchronized (list) {
            list.add(Thread.currentThread().getName());
            num--;
            if (num == 0) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }

        }
    }
}
