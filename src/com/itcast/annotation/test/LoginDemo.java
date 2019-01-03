package com.itcast.annotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<User> list = new ArrayList<>();
        User u1 = new User("zhangsan", "123456");
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("interspace");
        list1.add("publishLog");
        u1.setList(list1);
        User u2 = new User("lisi", "123456");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("interspace");
        list2.add("looktalk");
        u2.setList(list2);
        User u3 = new User("wangwu", "123456");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("looktalk");
        list3.add("publishLog");
        u3.setList(list3);
        User u4 = new User("zhaoliu", "123456");
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("interspace");
        list4.add("looktalk");
        list4.add("publishLog");
        u4.setList(list4);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        User user = new User(name, password);

        //判断
        for (User u : list) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                user = u;
            }
        }


        if (list.contains(user)){
            System.out.println("请输入您的选择：1、访问空间 2、查看说说 3、发表日志");
            String num = sc.next();
            switch (num) {
                case "1":
                    //访问空间
                    function("interspace",user);
                    break;
                case "2":
                    //查看说说
                    function("looktalk",user);
                    break;
                case "3":
                    //发表日志
                    function("publishLog",user);
                    break;
                default:
                    System.out.println("没有该选项");
                    System.out.println("谢谢使用");
                    break;
            }
        }else {
            System.out.println("请联系马化腾");
        }
    }

    public static void function(String funName, User user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.itcast.annotation.test.FunctionQQ");
        Method m = aClass.getDeclaredMethod(funName);
        Object o = aClass.newInstance();
        if (m.isAnnotationPresent(Jurisdiction.class)) {
            Jurisdiction annotation = m.getAnnotation(Jurisdiction.class);
            String value = annotation.value();
            if (user.getList().contains(value)) {
                m.invoke(o);
            }else {
                System.out.println("您没有使用权限！");
            }
        }





    }
}
