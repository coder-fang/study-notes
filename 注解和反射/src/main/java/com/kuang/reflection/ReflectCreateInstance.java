package com.kuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Create By  on 2021/10/4.
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.kuang.reflection.User");
        //2. 通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3. 通过public 的有参构造器创建实例
        //3.1 先得到对应构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2 创建实例 ，并传入实参
        Object hsp = constructor.newInstance("hsp");
        System.out.println("hsp="+hsp);
        //4. 通过非public的有参构造器创建实例
        //4.1 得到私有的构造器对象
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class,String.class);
        //4.2 创建实例
        //暴破（暴力破解） ，使用反射可以访问私有构造器/方法/属性
        declaredConstructor.setAccessible(true);
        Object user2 = declaredConstructor.newInstance(100, "小张");
        System.out.println("user2"+user2);
    }
}
    class User{
        private int age = 10;
        private String name = "fangfang";
        public User(){

        }
        public User(String name){
            this.name = name;
        }

        private User (int age,String name){
            this.age = age;
            this.name = name;
        }
        public String toString(){
            return "User [age=" + age +",name=" +name+"]";
        }

}
