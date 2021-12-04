package com.kuang.gaoji;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create By  on 2021/10/15.
 * 测试Lock锁
 * 多个对象操作同一个资源，不安全，可以加上Lock锁
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        //三个线程同时操作一个对象
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {
    int ticketNums = 10;
    // 定义Lock锁
    private final ReentrantLock lock = new ReentrantLock();  //可重用锁

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();  //加锁
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            }finally{
                //解锁
                lock.unlock();
            }

        }
    }
}
