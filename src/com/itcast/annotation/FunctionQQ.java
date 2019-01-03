package com.itcast.annotation;

public class FunctionQQ {
    //查看空间
    @Jurisdiction("interspace")
    public void interspace() {
        System.out.println("查看了女神的空间");
    }

    //查看说说
    @Jurisdiction("looktalk")
    public void looktalk() {
        System.out.println("查看了男神的说说");
    }

    //发表日志
    @Jurisdiction("publishLog")
    public void publishLog() {
        System.out.println("发表了一篇日志");
    }
}
