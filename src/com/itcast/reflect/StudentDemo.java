package com.itcast.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.itcast.reflect.Student");
//        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        /*System.out.println(constructor);
        System.out.println("--------------华丽的分割线-------------");
        Student stu = (Student) constructor.newInstance("张三");
        System.out.println(stu.getName());*/
        /*Object o = clazz.newInstance();
        Method showMethod = clazz.getDeclaredMethod("show", String[].class);
        String[] strings = {"nihao", "woshi"};
        showMethod.invoke(o, new Object[]{strings});*/
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);


    }
}
