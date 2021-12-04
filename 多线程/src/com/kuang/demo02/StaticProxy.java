package com.kuang.demo02;

/**
 * Create By  on 2021/10/14.
 * 静态代理
 */
//静态代理模式总结；
// 1. 真实对象和代理对象都需要实现同一个接口
// 2. 代理对象要代理真实角色
// 好处： 1. 代理对象可以做很多的真实对象做不了的事情
//   2. 真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        //Thread 是一个代理，真实对象 runnable接口  因此，线程底部实现原理是：静态代理模式
        new Thread(()-> System.out.println("i love you")).start();
        new WeddingCompany(you).HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}

class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("结婚~");
    }
}

class WeddingCompany implements Marry {
    //真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}

