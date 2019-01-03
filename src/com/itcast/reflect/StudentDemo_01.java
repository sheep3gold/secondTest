package com.itcast.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StudentDemo_01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取学生的字节码对象
        Class<?> aClass = Class.forName("com.itcast.reflect.Student");
        //获取私有构造函数
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor);
        System.out.println("--------------华丽的分割线--------------");

        constructor.setAccessible(true);
        Student stu = (Student) constructor.newInstance("李四", 18);
        System.out.println(stu.getName()+"--"+stu.getAge());
    }
}
