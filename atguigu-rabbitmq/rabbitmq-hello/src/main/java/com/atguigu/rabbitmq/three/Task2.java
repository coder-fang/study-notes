package com.atguigu.rabbitmq.three;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/1 14:46
 * 消息在手动应答时不丢失,放回队列中重新消费
 */
public class Task2 {
    //队列名称
    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        //开启发布确认
//        channel.confirmSelect();
        //声明队列
        boolean durable = true; //需要让queue进行持久化
//        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
        //创建临时队列
        String queueName = channel.queueDeclare().getQueue();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String message = scanner.next();
//            //设置生产者发送消息为持久化消息（要求保存到磁盘上）
//            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
//            System.out.println("生产者发出消息：" + message);
//        }
    }
}
