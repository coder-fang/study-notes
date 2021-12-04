package com.atguigu.rabbitmq.two;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/29 19:55
 * 这是一个工作线程（相当于之前的消费者）
 */
public class Worker01 {
    //队列名称
    public static final String QUEUE_NAME = "hello";

    //接收消息 的工作线程
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        //消息的接收
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息：" + new String(message.getBody()));
        };
        //消息接收被取消时 执行
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        };
        /*
         * 消费者 消费消息
         * 1.消费哪个队列
         * 2. 消费成功之后是否要自动应答，true代表自动应答,false代表手动应答。
         * 3. 消费者未成功消费的回调。
         * 4. 消费者取消消费的回调
         */
        System.out.println("C2等待接收消息......");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
