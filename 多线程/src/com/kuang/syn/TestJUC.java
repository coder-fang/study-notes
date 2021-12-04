package com.kuang.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Create By  on 2021/10/15.
 * 测试JUC安全类型的集合
 * 线程安全
 */
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
