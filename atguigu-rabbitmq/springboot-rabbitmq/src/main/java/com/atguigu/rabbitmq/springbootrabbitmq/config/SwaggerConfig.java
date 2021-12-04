package com.atguigu.rabbitmq.springbootrabbitmq.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/2 22:34
 */
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("rabbitmq  接口文档")
                .description(" 本文档描述了 rabbitmq  微服务接口定义")
                .version("1.0")
                .contact(new Contact("enjoy6288", "http://atguigu.com",
                        "1846015350@qq.com"))
                .build();
    }
}
