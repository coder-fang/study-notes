package com.kuang.reflection;

/**
 * Create By  on 2021/10/1.
 */

//测试class类的创建方式有哪些
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //向上转型
        Person person = new Student();
        System.out.println("这个人是："+ person.name);
        //方式一：父类引用指向子类对象
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二： forName 获得
        Class c2 = Class.forName("com.kuang.reflection.Student");
        System.out.println(c2.hashCode());

        //方式三： 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person{
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}
