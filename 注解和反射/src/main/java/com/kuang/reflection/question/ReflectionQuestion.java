package com.kuang.reflection.question;

import com.kuang.reflection.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Create By  on 2021/10/4.
 */
@SuppressWarnings("all")
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件re.properties 指定信息，创建Cat对象并调用方法hi
//        Properties properties = new Properties();
//        properties

        //传统方式 new 对象   -> 调用方法
//        Cat cat = new Cat();
//        cat.hi();

        //1. 使用Properties类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = (String) properties.get("method");

        //2. 创建对象 , 传统的方法行不通 -> 使用反射机制
//        new classfullpath()
        //3. 使用反射机制解决
        //（1）加载类，返回一个Class类型的对象
        Class cls = Class.forName(classfullpath);
        //（2） 通过aClass得到你加载的类 com.kuang.reflection.Cat 的对象的实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型="+ o.getClass());  //运行类型
        //(3) 通过cls 得到你加载的类 com.kuang.reflection.Cat 的methodName "hi" 的方法对象、
        //即；在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(method);
        //(4)通过method1 调用方法：即通过方法对象 调用方法
        System.out.println("=============================");
        method1.invoke(o);  // 传统方法: 对象.方法() , 反射机制: 方法对象.invoke(对象)
    }
}
