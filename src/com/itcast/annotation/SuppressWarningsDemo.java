package com.itcast.annotation;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class SuppressWarningsDemo {
    public void show() {
        List list = new ArrayList();
        list.add("张三");
        String s = null;
        s.length();
    }
}
