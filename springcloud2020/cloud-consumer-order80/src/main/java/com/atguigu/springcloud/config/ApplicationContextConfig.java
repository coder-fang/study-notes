package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/6 15:22
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   //使用@LoadBalanced 注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
