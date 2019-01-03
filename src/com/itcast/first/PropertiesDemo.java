package com.itcast.first;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        /*Properties properties = new Properties();
        properties.put("itcast01", "老唐");
        properties.put("itcast02", "老王");
        properties.put("itcast03", "建军");

        *//*System.out.println(properties.get("itcast01"));
        System.out.println(properties.get("itcast02"));
        System.out.println(properties.get("itcast03"));*//*

        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            String value = properties.getProperty(key);
            System.out.println(key+"---"+value);
        }*/
        Properties properties = new Properties();
        properties.load(new FileReader("names.txt"));
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            String value = properties.getProperty(key);
            System.out.println(key+"---"+value);
        }

    }
}
