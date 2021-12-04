package com.kuang.reflection;

import java.lang.reflect.Field;

/**
 *
 * 反射暴破操作属性
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1.得到Student01类对应的Class对象
        Class<?> aClass = Class.forName("com.kuang.reflection.Student01");
        //2.创建对象  //o的运行类型就是Student
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
        //3.使用反射得到age属性对象
        Field age = aClass.getField("age");
        age.set(o,88); //通过反射操作属性
        System.out.println(o);
        System.out.println(age.get(o)); //返回age属性的值

        //4.使用反射操作 私有、静态属性
        Field name = aClass.getDeclaredField("name");
        //对私有、静态属性使用暴破
        name.setAccessible(true);
//        name.set(o,"杉菜");
        name.set(null,"杉菜~");  //因为name是static属性，是属于所有对象的，在类加载的时候就已经有了，o也可以写成null
        System.out.println(o);
        System.out.println(name.get(o));  //获取属性值
        System.out.println(name.get(null));  //获取属性值，要求name是静态的
    }

}
class Student01{
    public int age;
    private static String name;
    public Student01(){

    }
    public String toString(){
        return "Student [age=" + age + ",name=" + name +"]";
    }
}
