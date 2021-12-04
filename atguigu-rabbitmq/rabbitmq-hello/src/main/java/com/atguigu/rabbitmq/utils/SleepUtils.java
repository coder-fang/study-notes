package com.atguigu.rabbitmq.utils;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/1 16:06
 * 睡眠工具类
 */
public class SleepUtils {
    public static void sleep(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
