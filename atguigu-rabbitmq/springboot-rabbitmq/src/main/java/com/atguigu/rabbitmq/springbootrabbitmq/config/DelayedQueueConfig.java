package com.atguigu.rabbitmq.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/3 16:41
 */
@Configuration
public class DelayedQueueConfig {
    //队列
    public static final String DELAYED_QUEUE_NAME = "delayed.name";
    //交换机
    public static final String DELAYED_EXCHANGE_NAME = "delayed.exchange";
    //routing-key
    public static final String DELAYED_ROUTING_KEY = "delayed.routingkey";

    //声明队列
    @Bean
    public Queue delayedQueue() {
        return QueueBuilder.durable(DELAYED_QUEUE_NAME).build();
    }

    //声明交换机 基于插件
    @Bean
    public CustomExchange delayedExchange() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-delayed-type", "direct");
        /**
         * 1. 交换机的名称
         * 2. 交换机的类型
         * 3. 是否需要持久化
         * 4. 是否需要自动删除
         * 5. 其他的参数
         */
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, arguments);
    }

    //绑定
    @Bean
    public Binding delayedQueueBindingDelayedExchange(@Qualifier("delayedQueue") Queue delayedQueue,
                                                      @Qualifier("delayedExchange") CustomExchange delayedExchange) {
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}
