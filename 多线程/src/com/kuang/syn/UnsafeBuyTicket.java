package com.kuang.syn;

/**
 * Create By  on 2021/10/15.
 * 不安全的买票
 */
public class UnsafeBuyTicket {

}

class BuyTicket implements Runnable {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你们").start();
        new Thread(buyTicket, "可恶的黄牛党").start();
    }

    //票
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized 同步方法，锁的是this（实现线程同步）  保证线程安全
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}
