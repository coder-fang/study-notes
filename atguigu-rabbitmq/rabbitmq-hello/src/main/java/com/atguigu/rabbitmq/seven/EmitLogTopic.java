package com.atguigu.rabbitmq.seven;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.spec.ECField;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/2 14:45
 * 生产者
 */
public class EmitLogTopic {
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        /**
         * 下图绑定关系如下：
         * Q1--> 绑定的是： 中间带3个单词的字符串（*.orange*）
         * Q2--> 绑定的是： 最后一个单词是rabbit的3个单词（*.*.rabbit）
         *                第一个单词是lazy的多个单词（lazy.#）
         */
        Map<String, String> bindingKeyMap = new HashMap<>();
        bindingKeyMap.put("quick.orange.rabbit", "被队列Q1Q2接收到");
        bindingKeyMap.put("lazy.orange.elephant", "被队列Q1Q2接收到");
        bindingKeyMap.put("lazy.pink.rabbit", "被队列Q1接收到");
        bindingKeyMap.put("quick.brown.fox", "被队列Q2接收到");
        bindingKeyMap.put("quick.orange.male.rabbit", "虽然满足两个绑定但只被队列Q2接收一次");
        bindingKeyMap.put("quick.brown.fox", "不匹配任何绑定不会被任何队列接收到会被丢弃");
        bindingKeyMap.put("lazy.orange.male.rabbit", "是四个单词不匹配任何绑定定会丢弃");
        bindingKeyMap.put("lazy.orange.male.rabbit", "是四个单词但匹配Q2");

        for (Map.Entry<String, String> bindingKeyEntry : bindingKeyMap.entrySet()) {
            String routingKey = bindingKeyEntry.getKey();
            String message = bindingKeyEntry.getValue();
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息" + message);
        }
    }
}
