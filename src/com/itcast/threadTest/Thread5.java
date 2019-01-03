package com.itcast.threadTest;

public class Thread5 implements Runnable {
    //    private int num;
    int priority;

//    public Thread5(int num) {
//        this.num = num;
//    }
    @Override
    public void run() {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName()+"正在运行");
        }*/
        synchronized ("1"){
        priority = Thread.currentThread().getPriority();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (priority == 10) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()
                    +"正在运行");
                }
            } else if (priority == 6) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()
                    +"正在运行");
                }
            }
        }
    }
}
