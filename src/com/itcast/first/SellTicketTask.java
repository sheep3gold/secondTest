package com.itcast.first;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class SellTicketTask implements Runnable {


    private static Object obj = new Object();

    private int tickets = 1000;
    Lock ck = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {
                ck.lock();
                if (tickets > 0) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出票，剩余" + tickets + "张票");

                    tickets--;

                }else break;
                ck.unlock();
//                    break;
//            }

        }
    }

}

