package com.kuang.reflection;

/**
 * Create By  on 2021/10/4.
 */
public class Cat {
    private String name = "招财猫";
    public int age = 18;

    public Cat(){

    }

    public void hi() {   //常用方法
//        System.out.println("hi " + name);
    }
    public void cry(){
        System.out.println(name+" 喵喵~");
    }
    public Cat(String name){
        this.name = name;
    }
}

