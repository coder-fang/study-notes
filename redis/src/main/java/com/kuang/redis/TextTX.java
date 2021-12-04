package com.kuang.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Create By  on 2021/10/10.
 * 事务
 */
public class TextTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","kuangshen");
        Transaction multi = jedis.multi();  //开启事务
        String result = jsonObject.toJSONString();
        try {
            multi.set("user1",result);
            multi.set("user2",result);
            int i = 1/0;
            multi.exec();  //执行事务
        } catch (Exception e) {
            multi.discard();  //放弃事务
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();  //关闭连接
        }
    }
}
