package com.atguigu.rabbitmq.one;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/28 22:15
 * 生产者 ：发消息
 */
public class Producer {
    //队列名称
    private static final String QUEUE_NAME = "hello1";

    //发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个连接工厂
//        ConnectionFactory factory = new ConnectionFactory();
//        //设置工厂ip  连接rabbitmq的队列
//        factory.setHost("59.110.171.189");
//        //用户名
//        factory.setUsername("admin");
//        //密码
//        factory.setPassword("123");
//        //创建连接
//        Connection connection = factory.newConnection();
//        //获取信道
//        Channel channel = connection.createChannel();
        Channel channel = RabbitMqUtils.getChannel();
        /**
         * 生成一个队列
         * 参数；1.队列名称
         *      2.队列里面的消息是否持久化（磁盘），默认消息存储在内存中（不持久化false）
         *      3.该队列是否只供一个消费者进行消费，是否消息独有，true只允许一个消费者进行消费，默认是false（可以多个消费者消费）
         4. 是否自动删除，最后一个消费者断开连接后，该队列是否自动删除，true自动删除，false不自动删除
         5.其他参数（延迟消息......）
         */
        Map<String, Object> arguments = new HashMap<>();
        //官方允许是0-255之间。此处设置10. 允许优先级范围为0-10   不要设置过大   浪费CPU与内存
        arguments.put("x-max-priority", 10);
        channel.queueDeclare(QUEUE_NAME, true, false, false, arguments);
        //发消息
        for (int i = 0; i < 11; i++) {
            String message = "info" + i;
            if (i == 5) {
                //设置优先级
                AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().priority(5).build();
                channel.basicPublish("", QUEUE_NAME, properties, message.getBytes());
            } else {
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            }
        }
        /*
         * 发送一个消息
         * 1. 发送到哪个交换机
         * 2. 路由的key值是哪个，本次是队列的名称
         * 3. 其他参数信息
         * 4. 发送消息的消息体
         */
        System.out.println("消息发送完毕");
    }
}
