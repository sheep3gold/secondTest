package com.itcast.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("zhangsan");
        user1.setPassword("123456");
        //添加用户具备的权限
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("interspace");
        list1.add("publishLog");
        user1.setList(list1);
        userList.add(user1);
        User user2 = new User();
        user2.setUsername("lisan");
        user2.setPassword("123456");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("interspace");
        list2.add("looktalk");
        user2.setList(list2);
        userList.add(user2);
        User user3 = new User();
        user3.setUsername("wangwu");
        user3.setPassword("123456");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("interspace");
        list3.add("publishLog");
        list3.add("looktalk");
        user3.setList(list3);
        userList.add(user3);

        //使用键盘录入模拟用户登陆
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入账号");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //找到与用户登陆的账号一致的用户

        for (User u : userList) {
            /*if (u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword())) {
                user = u;
            }*/
            if (u.equals(user)) {
                user = u;
            }
        }


        if (userList.contains(user)) {
            System.out.println(user.getUsername() + "欢迎您访问腾讯管理系统");
            System.out.println("请输入您的选择 1：访问空间 2：查看说说 3：发表日志");
            String choose = sc.next();
            FunctionQQ fu = new FunctionQQ();
            switch (choose){
                case "1":
                    //访问别人的空间
//                    fu.interspace();
                    function("interspace",user);
                    break;
                case "2":
                    //查看别人的说说
//                    fu.looktalk();
                    function("looktalk",user);
                    break;
                case "3":
                    //发表日志
//                    fu.publishLog();
                    function("publishLog",user);
                    break;
                default:
                    System.out.println("没有这样的选择");
                    break;
            }
        }else {
            System.out.println("请直接联系马化腾!");
        }

    }

    public static void function(String methodName, User user) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.itcast.annotation.FunctionQQ");
        Object o = aClass.newInstance();
        Method method = aClass.getDeclaredMethod(methodName);
        if (method.isAnnotationPresent(Jurisdiction.class)) {
            Jurisdiction annotation = method.getAnnotation(Jurisdiction.class);
            String value = annotation.value();
            if (user.getList().contains(value)) {
                method.invoke(o);
            }else {
                System.out.println("你没有这样的权限调用");
            }
        }
    }
}
