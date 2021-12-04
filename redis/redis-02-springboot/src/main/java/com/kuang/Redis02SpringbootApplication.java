package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.kuang.config")
@SpringBootApplication
public class Redis02SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Redis02SpringbootApplication.class, args);
    }

}
