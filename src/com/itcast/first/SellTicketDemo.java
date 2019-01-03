package com.itcast.first;

public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicketTask stt = new SellTicketTask();
        Thread t1 = new Thread(stt, "窗口1");
        Thread t2 = new Thread(stt, "窗口2");
        Thread t3 = new Thread(stt, "窗口3");
        Thread t4 = new Thread(stt, "窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        /*SellTicketTask t1 = new SellTicketTask();
        t1.setName("线程1");
        SellTicketTask t2 = new SellTicketTask();
        t2.setName("线程2");
        SellTicketTask t3 = new SellTicketTask();
        t3.setName("线程3");
        SellTicketTask t4 = new SellTicketTask();
        t4.setName("线程4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(Thread.currentThread().getName());*/
    }
}
