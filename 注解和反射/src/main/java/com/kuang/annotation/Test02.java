package com.kuang.annotation;

import java.lang.reflect.Field;

/**
 * Create By  on 2021/10/1.
 */
//什么叫反射
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1.通过反射获取类的class对象
        Class c1 = Class.forName("com.kuang.annotation.User");
        System.out.println(c1);  //显示cls对象，是哪个类的class对象  com.kuang.annotation.User
        //2.输出c1运行类型  java.lang.Class
        System.out.println(c1.getClass());
        //3.得到包名
        System.out.println(c1.getPackage().getName()); //包名
        //4.得到全类名
        System.out.println(c1.getName());
        //5.通过c1创建对象实例
        User user = (User)c1.newInstance();
        System.out.println(user);
        //6.通过反射获取属性id
        Field id = c1.getField("id");
        System.out.println(id.get(user)); //2
        //7.通过反射给属性赋值
        id.set(user,8);
        System.out.println("id为："+id.get(user));
        //8.获取所有的（字段）属性
        System.out.println("========所有的字段属性==========");
        Field[] fields = c1.getFields();
        for (Field f:fields){
            System.out.println(f.getName());  //名字
        }

        Class c2 = Class.forName("com.kuang.annotation.User");
        Class c3 = Class.forName("com.kuang.annotation.User");
        Class c4 = Class.forName("com.kuang.annotation.User");

        //一个类在内存中只有一个class对象
        //一个类被加载后，类的整个结构都会被封装在class对象中。
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}

//实体类 ：pojo ,entity
class User {
    public String name;
    public int id = 2;
    public int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
