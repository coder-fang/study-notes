package com.atguigu.rabbitmq.four;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/1 21:32
 * 发布确认模式：
 * 使用的时间  比较哪种确认方式是最好的
 * 1.单个确认
 * 2.批量确认
 * 3.异步批量确认
 */
public class ConfireMessage {
    //批量发消息的个数
    public static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException, TimeoutException, IOException {
        //1. 单个确认
//        ConfireMessage.publicMessageIndividually(); //发布1000个单独确认消息，耗时29726ms
//        2. 批量确认
//        ConfireMessage.publicMessageBatch();  //发布1000个批量确认消息，耗时761ms（弊端：无法确认哪个消息未被确认）
//        3. 异步确认
        ConfireMessage.publicMessageAsync(); //发布1000个异步确认消息，耗时181ms  // 发布1000个异步确认消息，耗时59ms
    }


    //单个确认
    public static void publicMessageIndividually() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        //用信道声明队列
        channel.queueDeclare(queueName, true, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        //开始时间
        long begin = System.currentTimeMillis();
        //批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String massage = i + "";
            channel.basicPublish("", queueName, null, massage.getBytes());
            //单个消息就马上进行发布确认
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息，耗时" + (end - begin) + "ms");
    }

    //批量发布确认
    public static void publicMessageBatch() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        //用信道声明队列
        channel.queueDeclare(queueName, true, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        //开始时间
        long begin = System.currentTimeMillis();
        //批量确认消息大小
        int batchSize = 100;
        //批量发布消息， 批量发布确认
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            //发布确认
            if (i % batchSize == 0) {
                channel.waitForConfirms();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个批量确认消息，耗时" + (end - begin) + "ms");
    }

    //异步发布确认
    public static void publicMessageAsync() throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        //用信道声明队列
        channel.queueDeclare(queueName, true, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        /*
        线程安全有序的哈希表，适用于高并发的情况
        1. 轻松的将序号与消息进行关联
        2. 轻松批量删除条目，只要给序号
        3.支持高并发(多线程)
         */
        ConcurrentSkipListMap<Long,String> outstandingConfirms = new ConcurrentSkipListMap<>();

        //消息确认成功，回调函数
        ConfirmCallback ackCallback = (deliveryTag, multiple) -> {
            //2. 删除已经确认的消息   剩下的就是未确认的消息
            if(multiple){
                //如果是批量确认，就去批量删除
                ConcurrentNavigableMap<Long,String> confirmed = outstandingConfirms.headMap(deliveryTag);
                confirmed.clear();
            }else{
                //如果是单个确认，就去单个删除
                outstandingConfirms.remove(deliveryTag);
            }
            System.out.println("确认的消息" + deliveryTag);
        };
        //消息确认失败，回调函数
        ConfirmCallback nackCallback = (deliveryTag, multiple) -> {
            //3. 打印未确认的消息有哪些
            String message = outstandingConfirms.get(deliveryTag);
            System.out.println("未确认的消息是："+message+":::::未确认的消息tag:" + deliveryTag);
        };
        //准备消息的监听器，监听哪些消息成功了，哪些消息失败了
        channel.addConfirmListener(ackCallback, nackCallback);  //异步通知
        //开始时间
        long begin = System.currentTimeMillis();
        //批量发送消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = "消息" + i;
            // 1. 此处记录下所有要发送的消息  消息的总和(每发一次消息就记录一次)
            outstandingConfirms.put(channel.getNextPublishSeqNo(),message);
            channel.basicPublish("", queueName, null, message.getBytes());

        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个异步确认消息，耗时" + (end - begin) + "ms");
    }
}
