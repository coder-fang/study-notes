package com.kuang.annotation;

import org.springframework.context.annotation.Profile;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 解析注解
 */

@Pro(className = "com.kuang.annotation.Demo1" ,methodName = "show")
public class ParseAnnotation {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ParseAnnotation> parseAnnotationClass = ParseAnnotation.class;
        //1.2获取字节码对象
        /*
         * getAnnotation(Class)
         * 其实就是在内存中生成了一个该注解接口的子类实现对象
         * public class ProImpl implements Pro{
         *     public String className(){
         *         return "com.kuang.annotation.Demo1";
         *     }
         *     public String methodName(){
         *         return "show";
         *     }
         * }
         */
        Pro annotation = parseAnnotationClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        String c = annotation.className();   //拿到注解中定义的属性值
        String s = annotation.methodName();
        System.out.println(c);
        System.out.println(s);
        //加载该类进内存
        Class<?> aClass = Class.forName(c);
        //创建对象
        Object o = aClass.newInstance();
        //获取方法对象
        Method method = aClass.getMethod(s);
        //执行方法
        method.invoke(o);
    }
}
