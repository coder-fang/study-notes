package com.kuang.syn;

import com.kuang.state.TestJoin;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By  on 2021/10/15.
 * 线程不安全的集合
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
            try {
//                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(list.size());
    }
}
