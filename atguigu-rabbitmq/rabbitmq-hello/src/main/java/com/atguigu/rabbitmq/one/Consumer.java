package com.atguigu.rabbitmq.one;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/29 15:04
 * 消费者:接收消息
 */
public class Consumer {
    //队列名称
    public static final String QUEUE_NAME = "hello1";

    //接收消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("59.110.171.189");
//        factory.setUsername("admin");
//        factory.setPassword("123");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
        Channel channel = RabbitMqUtils.getChannel();
        //声明 接收消息(成功后的回调)
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
        };
        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息消费被中断");
        };
        /*
         * 消费者 消费消息
         * 1.消费哪个队列
         * 2. 消费成功之后是否要自动应答，true代表自动应答,false代表手动应答。
         * 3. 消费者未成功消费的回调。
         * 4. 消费者取消消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
