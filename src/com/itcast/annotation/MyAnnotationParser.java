package com.itcast.annotation;

import java.lang.reflect.Method;

public class MyAnnotationParser {
    public static void main(String[] args) throws NoSuchMethodException {
        //使用反射技术解析使用了注解的类或方法
        //1、获得类的字节码文件对象
        Class clazz = Demo2.class;
        //2、获得使用注解的方法
        Method method = clazz.getDeclaredMethod("method");
        MyAnnotation2 ann = method.getAnnotation(MyAnnotation2.class);
        System.out.println(ann.names());
        String[] names = ann.names();
        for (String name : names) {
            System.out.println(name);
        }
        int age = ann.age();
        System.out.println(age);
        String value = ann.value();
        System.out.println(value);
    }
}
