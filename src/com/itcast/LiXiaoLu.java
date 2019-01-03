package com.itcast;

public class LiXiaoLu implements SmallStar{
    public void sing(int money){
        System.out.println("给了李小璐" + money + "块钱,给我们唱歌!");
    }

    public void dance(int money){
        System.out.println("给了李小璐" + money + "块钱,给我们跳舞!");
    }

    public void acting(int money){
        System.out.println("给了李小璐" + money + "块钱,给我们演戏!");
    }

    public void sleep(){
        System.out.println("睡觉zzZZZZZZ");
    }
}
