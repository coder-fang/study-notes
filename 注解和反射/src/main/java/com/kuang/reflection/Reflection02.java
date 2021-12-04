package com.kuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create By  on 2021/10/4.
 */
//测试反射调用的性能和优化
public class Reflection02 {
//    Field
//    Constructor
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        m1();
        m2();
        m3();
    }

    //传统方法调用hi
    public static void m1(){
        long start = System.currentTimeMillis();
        Cat cat = new Cat();
        for (int i = 0; i<90000000;i++){
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法来调用hi 耗时="+(end - start));
    }

    //反射机制来调用hi
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        Class cls = Class.forName("com.kuang.reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");

        for (int i = 0;i<90000000;i++){
            hi.invoke(o);  //反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制来调用hi 耗时="+(end-start));
    }

    //反射调用优化 + 关闭访问检查
    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        long start = System.currentTimeMillis();
        Class cls = Class.forName("com.kuang.reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);  //在反射调用方法时，取消访问检查
        for (int i = 0;i<90000000;i++){
            hi.invoke(o);  //反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制来调用hi 耗时="+(end-start));
    }
}
