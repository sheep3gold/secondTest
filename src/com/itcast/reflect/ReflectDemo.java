package com.itcast.reflect;

import java.lang.reflect.Field;

public class ReflectDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person("张三", 19, "上海");
        Class pClass = p.getClass();

        Field f = pClass.getDeclaredField("age");
        Field f2 = pClass.getDeclaredField("name");
        System.out.println(f2);

        int age = (int) f.get(p);
        System.out.println(age);
        f.set(p, 18);
        int age1 = (int) f.get(p);
        System.out.println(age1);

        f2.setAccessible(true);
        String name = (String) f2.get(p);
        System.out.println(name);
        f2.set(p, "李四");
        String name2 = (String) f2.get(p);
        System.out.println(name2);
    }
}
