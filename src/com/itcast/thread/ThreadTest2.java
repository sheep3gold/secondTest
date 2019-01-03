package com.itcast.thread;

public class ThreadTest2 {
    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("播放背景音乐");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("显示画面");
                }
            }
        }).start();*/
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("播放背景音乐");
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("显示画面");
            }
        }).start();

    }
}
