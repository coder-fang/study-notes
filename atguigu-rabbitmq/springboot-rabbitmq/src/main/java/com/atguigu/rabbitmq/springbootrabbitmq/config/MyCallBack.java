package com.atguigu.rabbitmq.springbootrabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/3 20:50
 * 回调接口
 */
@Slf4j
@Component
public class MyCallBack implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        //注入 （需要将当前实现类注入到RabbitTemplate的ConfirmCallback函数式接口中）
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 交换机确认回调方法
     * 1. 发消息  交换机接收到了  回调
     * 1.1 correlationData 保存回调消息的id及相关信息
     * 1.2 交换机收到消息  ack = true
     * 1.3 cause  null
     * 2. 发消息 交换机接收失败 回调
     * 2.1 correlationData 保存回调消息的id及相关信息
     * 2.2 交换机收到消息 ack = false
     * 2.3 cause  失败的原因
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData != null ? correlationData.getId() : "";
        if (ack) {
            log.info("交换机已经收到id为：{}的消息", id);
        } else {
            log.error("交换机还未收到id为:{}的消息，由于原因：{}", id, cause);
        }
    }

    /**
     * 可以在当消息传递过程中，不可达目的地时将消息返回给生产者
     * 只有不可到目的地时，才进行回退
     *
     * @param returnedMessage
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("消息{}，被交换机{}退回，退回原因：{},路由key:{}",
                new String(returnedMessage.getMessage().getBody()),
                returnedMessage.getExchange(),
                returnedMessage.getReplyText(),
                returnedMessage.getRoutingKey());
    }
}
