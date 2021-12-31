package com.atguigu.springcloud;

import java.time.ZonedDateTime;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/31 15:15
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        //2021-02-22T15:51:37.485+08:00[Asia/Shanghai]
    }
}
