package com.kuang.demo02;

/**
 * Create By  on 2021/10/14.
 */
public class TestLambda2 {


    public static void main(String[] args) {
//        class Love implements ILove {
//            @Override
//            public void love(int a) {
//                System.out.println("i love you-->" + a);
//            }
//        }
        //0.定义接口实现的对象
        ILove love = (int a,String name) -> {
            System.out.println("i love you-->" + a);
        };
        // 简化 1. 去掉参数类型
        love = (a,name) -> {
            System.out.println("i love you-->" + a);
        };

        // 简化2.去掉括号
        love = (a,name) -> System.out.println("i love you-->" + a + 678+name);
        // 总结:
        //  1. lambda 表达式只能有一行代码的情况下，才能简化成一行，如果有多行，那么就用代码块包裹
        // 2. 前提是接口为函数式接口（接口内部只有一个方法）
        // 3. 多个参数也可以去掉参数类型,要去掉都去掉，必须加上括号
        love.love(520,"hiuh");
    }
}

interface ILove {
    void love(int a, String name);
}

