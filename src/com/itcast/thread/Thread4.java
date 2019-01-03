package com.itcast.thread;

public class Thread4 implements Runnable{
    private  int num = 1;
    private  Object object = new Object();
    @Override
    public void run() {
        cross();
    }

    public synchronized void cross() {

//            synchronized (object) {
//                if (num <= 10) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "第" + num
                            + "个通过");
//                    Thread.yield();
                    num++;

//                } else break;
//            }
        }
//    }
    /*private int crossNum = 0;

    @Override
    public void run() {
        cross();
    }

    public void cross() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        crossNum++;
        System.out.println(Thread.currentThread().getName()+"是第"+crossNum);

    }*/
}
