package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/20 14:58
 */

/*
 * NONE：默认的，不显示任何日志;
 * BASIC：仅记录请求方法、URL、响应状态码及执行时间;
 * HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息;
 * FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
 *
 * @date 2021/12/20 15:34
 */

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
