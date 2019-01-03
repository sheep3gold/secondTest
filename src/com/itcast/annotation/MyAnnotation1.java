package com.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MyAnnotation1 {
    //添加属性
    String value();
}
