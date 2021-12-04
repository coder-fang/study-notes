package com.kuang.demo01;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JucApplication {

    public static void main(String[] args) {
//        SpringApplication.run(JucApplication.class, args);
        // 获取cpu的核数
        // CPU 密集型   IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
