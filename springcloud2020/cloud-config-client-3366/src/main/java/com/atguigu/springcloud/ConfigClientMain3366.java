package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/1/9 15:42
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3366{
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class, args);
    }
}

