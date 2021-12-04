package com.kuang.demo01;

/**
 * Create By  on 2021/10/14.
 * 多个线程同时操作同一个对象
 * 例子：买火车票
 */
//发现问题；多个线程操作同一个资源，线程不安全。数据紊乱（线程并发问题）
public class TestThread4 implements Runnable {
    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();

    }
}
