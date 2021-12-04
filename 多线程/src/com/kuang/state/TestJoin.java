package com.kuang.state;

/**
 * Create By  on 2021/10/15.
 * 测试join方法 （想象为插队）(会让线程阻塞。尽量少用)
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了!!!!!!!!!!!!!!" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        //主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join();  //插队
            }
            System.out.println("main" + i);
        }
    }
}
