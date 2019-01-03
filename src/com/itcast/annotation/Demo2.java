package com.itcast.annotation;

//@MyAnnotation2(age = 10, names = {"张三", "李四"}, value = "王五")
public class Demo2 {
//    @MyAnnotation1(value="哈哈")
    @MyAnnotation2(age = 10, names = {"张三", "李四"}, value = "王五")
    public void method() {
        System.out.println("method...");
    }
}
