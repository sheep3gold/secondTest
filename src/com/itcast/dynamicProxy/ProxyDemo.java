package com.itcast.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        LiXiaoLu lulu = new LiXiaoLu();
        ClassLoader classLoader = lulu.getClass().getClassLoader();
        Class<?>[] interfaces = lulu.getClass().getInterfaces();
        SmallStar ss = (SmallStar) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;
                if (method.getName().equals("sleep")) {
                    obj=method.invoke(lulu, args);
                } else {
                    int money = (int) args[0];
                    System.out.println("签合同");
                    System.out.println("经纪人" + (money * 0.3) + "元");
                    obj = method.invoke(lulu, (int)(money * 0.7));
                    System.out.println("付尾款");
                }
//                Object obj = method.invoke(lulu, args);
                return obj;
            }
        });
        ss.sing(100);
        ss.dance(200);
        ss.acting(300);
        ss.sleep();
    }
}

