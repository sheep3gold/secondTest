package com.itcast;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        //被代理对象
        LiXiaoLu lulu = new LiXiaoLu();
        //lulu.sing(100);
        //增强功能 -- 原有功能不变 将功能进行放大
        //使用 动态代理
        //创建 -- 代理对象
        //代理对象 -- 经纪人
        //被代理对象 -- 李小璐
        //1.需要创建一个接口  -- 需要被 被代理对象实现
        //2.使用Proxy 调用 static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        /*
            ClassLoader -- 类加载器
            interfaces -- 被代理对象实现的所有的接口
            InvocationHandler h -- 接口的实现类对象
         */
        //获取类加载器
        ClassLoader loader = lulu.getClass().getClassLoader();
        //被代理对象实现的所有接口
        Class<?>[] interfaces = lulu.getClass().getInterfaces();
        //创建代理对象 -- 可以使用 被代理对象实现的接口 接收
        SmallStar ss = (SmallStar) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //使用代理对象调用的方法  全部集中到了这里
               //返回值  代理对象调用方法时 当方法有返回值时  需要返回
                //method -- 方法 代理对象调用的方法  会赋值给这个参数
                //args -- 参数  代理对象调用方法时的参数列表
                //proxy -- 使用动态代理需要注意的地方 -- 代理对象 -- 慎用!!!
               // System.out.println(proxy.toString());  StackOverflowError 栈内存溢出
                String methodName = method.getName();
                Object obj = null;
                if(methodName.equals("sleep")){
                    obj = method.invoke(lulu, args);
                }else{
                    //剩下的方法需要增强
                    int money = (int) args[0];
                    System.out.println("签合同");
                    System.out.println("经纪人提成" + (money * 0.3) + "元" );
                    obj = method.invoke(lulu, (int)(money * 0.7));
                    System.out.println("鼓掌....演的真好啊,你好棒!!!!!");
                }
                return obj;
            }
        });
        //使用代理对象调用方法
        ss.sing(10000);
        ss.acting(12000);
        ss.dance(6999);
        ss.sleep();
    }
}
