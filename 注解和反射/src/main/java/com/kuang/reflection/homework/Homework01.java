package com.kuang.reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        /**
         * 定义PrivateTest类，有私有name属性，并且属性值为hellokitty
         * 提供getName公有方法
         * 创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法 打印name属性值
         */
        // 1.得到PrivateTest类对应的Class对象
        Class<?> privateTestCls = Class.forName("com.kuang.reflection.homework.PrivateTest");
        //2.创建对象
        Object o = privateTestCls.newInstance();
        //3. 获取属性对象
        Field name = privateTestCls.getDeclaredField("name");
        name.setAccessible(true);  //暴破
        name.set(o,"miaomiao");
        System.out.println(name.get(o));
        //4.得到方法对象
        Method getName = privateTestCls.getDeclaredMethod("getName");
        System.out.println(getName.invoke(o));
    }
}

class PrivateTest{
    private String name = "hellokitty";
    public String getName(){
        return name;
    }
}
