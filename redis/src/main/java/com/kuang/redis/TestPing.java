package com.kuang.redis;
import redis.clients.jedis.Jedis;

/**
 * Create By  on 2021/10/10.
 * 测试连接redis
 */
public class TestPing {
    public static void main(String[] args) {
        // 1. new Jedis 对象即可
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //  jedis 所有的命令就是我们之前学习的所有指令
        System.out.println(jedis.ping());
    }
}
