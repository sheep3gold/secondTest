package com.itcast.dynamicProxy;

public class LiXiaoLu implements SmallStar {
    @Override
    public void sing(int money) {
        System.out.println("给了"+money+"块钱，给我唱歌");
    }

    @Override
    public void dance(int money) {
        System.out.println("给了"+money+"块钱,给我跳舞");
    }

    @Override
    public void acting(int money) {
        System.out.println("给了"+money+"块钱，给我演戏");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉zzZZZ");
    }
}
