package com.atguigu.rabbitmq.two;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/29 21:04
 * 生产者 发送大量消息
 */
public class Task01 {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        /*
         * 生成一个队列
         * 参数；1.队列名称
         *      2.队列里面的消息是否持久化（磁盘），默认消息存储在内存中（不持久化false）
         *      3.该队列是否只供一个消费者进行消费，是否消息独有，true只允许一个消费者进行消费，默认是false（可以多个消费者消费）
         4. 是否自动删除，最后一个消费者断开连接后，该队列是否自动删除，true自动删除，false不自动删除
         5.其他参数（延迟消息......）
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("发送消息完成：" + message);
        }
    }
}
