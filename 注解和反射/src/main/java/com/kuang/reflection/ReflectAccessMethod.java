package com.kuang.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射调用方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.得到Boss类对应的class对象
        Class<?> bossCls = Class.forName("com.kuang.reflection.Boss");
        //2.创建对象
        Object o = bossCls.newInstance();
        //3.得到public方法对象
//        Method hi = bossCls.getMethod("hi",String.class);
        //3.1 得到所有方法对象
        Method hi = bossCls.getDeclaredMethod("hi", String.class);
        //3.2 调用
        hi.invoke(o,"杉菜酱~");
        //4.调用私有静态方法
        //4.1 得到say方法对象
        Method say = bossCls.getDeclaredMethod("say", int.class,String.class, char.class);
        //4.2 因为say方法是private，所以需要暴破
        say.setAccessible(true);
        System.out.println(say.invoke(o, 2, "888", '9'));
        //4.3 因为say方法是静态的，还可以这样调用,可以给对象传入空
        System.out.println(say.invoke(null,200,"66",'5'));

        //5.在反射中，如果方法有返回值，统一返回Object，但是他运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "wangwu", 'm');
        System.out.println("reVal的运行类型="+reVal.getClass());   //返回say方法的运行类型 String
    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {

    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi " + s);
    }
}
