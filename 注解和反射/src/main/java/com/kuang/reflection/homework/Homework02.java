package com.kuang.reflection.homework;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create By  on 2021/10/5.
 */
public class Homework02 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * 利用Class类的forName属性得到File类的class对象
         * 在控制台打印File类的所有构造器
         * 通过newInstance的方法创建File对象，并创建E:\mynew.txt文件
         */
        Class<?> fileClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File构造器= "+declaredConstructor);
        }
        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        String filePath = "e:\\mynew.txt";
        Object file = declaredConstructor.newInstance(filePath);
        System.out.println(file.getClass());
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(file);
    }
}
