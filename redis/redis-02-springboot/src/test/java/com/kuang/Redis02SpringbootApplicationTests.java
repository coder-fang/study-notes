package com.kuang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kuang.pojo.User;
import com.kuang.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
//    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        //redisTemplate 操作不同的数据类型，api和我们的指令是一样的
        //opsForValue 操作字符串
        //opsForList 操作List 类似List
        //opsForSet
        //opsForZSet
        //opsForGeo
        //opsForHyperLog
        //除了基本的方法，我们常用的方法都可以直接通过redisTemplate操作。比如事务和基本的CRUD

//        redisTemplate.

        //获取数据库的连接 (一般很少用)
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("mykey", "kuangshen");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test() throws JsonProcessingException {
        //真实的开发一般都使用json来传递对象
        User user = new User("狂神说", 18);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test1(){
        redisUtil.set("name","kuangshen");
        System.out.println(redisUtil.get("name"));
    }

}
