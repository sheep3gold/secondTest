package com.itcast.reflect;

public class ClassDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一
        Class clazz = String.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        //方式二
        Class class2 = "柳岩".getClass();
        System.out.println(class2.getName());
        System.out.println(class2.getSimpleName());

        //方式三
        Class class3 = Class.forName("java.lang.String");
        System.out.println(class3.getName());
        System.out.println(class3.getSimpleName());

        System.out.println(clazz == class2);
        System.out.println(clazz == class3);
        System.out.println(class2 == class3);
    }
}
