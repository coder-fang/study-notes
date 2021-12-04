package com.atguigu.rabbitmq.springbootrabbitmq.controller;

import com.atguigu.rabbitmq.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/3 20:27
 * 开始发消息
 */
@Slf4j
@RestController
@RequestMapping("/confirm")
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发消息
    @GetMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable String message) {
        CorrelationData correlationData1 = new CorrelationData("1");
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME,
                ConfirmConfig.CONFIRM_ROUTING_KEY, message + "key1", correlationData1);
        log.info("发送消息内容为：{}", message + "key1");

        CorrelationData correlationData2 = new CorrelationData("3");
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME,
                ConfirmConfig.CONFIRM_ROUTING_KEY + "13", message + "key13", correlationData2);
        log.info("发送消息内容为：{}", message + "key13");
    }
}
