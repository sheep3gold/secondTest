package com.itcast.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo_01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.itcast.reflect.Person");
        Method method = aClass.getDeclaredMethod("setName", String.class);
        Person p = new Person();
        Object o = method.invoke(p, "赵四");
        System.out.println(p);
        System.out.println(o);
        System.out.println(p.getName());
    }
}
