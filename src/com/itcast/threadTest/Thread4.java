package com.itcast.threadTest;

import java.util.Random;

public class Thread4 extends Thread {

    private int money;

    private static int money5 = 3;
    private static int money10 = 0;
    private static int money20 = 0;

    public Thread4(int money) {
        this.money = money;
    }
    @Override
    public void run() {
        try {
            rule(money);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void rule(int money) throws InterruptedException {
            synchronized ("1") {
                if (money == 5) {
                    money5++;
                    System.out.println(Thread.currentThread().getName() + "钱正好，您的电影票");
//                notify();
                } else if (money == 10) {
                    while (money5 < 1) {
                        wait();
//                    notify();
                    }
                    money10++;
                    money5--;
                    System.out.println(Thread.currentThread().getName() + "找您5元，谢谢光临");
                } else if (money == 20) {
                    while (money10 < 1 && money5 < 3) {
                        wait();
                    }
                    if (money10 >= 1) {
                        while (money5 < 1) {
                            wait();
                        }
                        money10--;
                        money5--;
                        money20++;
                        System.out.println(Thread.currentThread().getName() + "找您一张10块和一张五块");
//                    notify();
                    } else {
                        money5 -= 3;
                        money20++;
                        System.out.println(Thread.currentThread().getName() + "找您三张5块");
//                    notify();
                    }


                }

                this.notify();

                System.out.println(Thread.currentThread().getName() + " "
                        + money + "," + money5 + "," + money10 + "," + money20);
            }
    }
}
