package com.itcast.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class PersonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileReader("classpath.properties"));
        String classpath = properties.getProperty("classpath");
        Class<?> aClass = Class.forName(classpath);
        Object o = aClass.newInstance();
        Method cycle = aClass.getDeclaredMethod("cycle");
        cycle.invoke(o);
    }
}
