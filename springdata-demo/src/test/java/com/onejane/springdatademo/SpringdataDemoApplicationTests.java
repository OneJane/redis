package com.onejane.springdatademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest// 默认 (classes = {SpringdataDemoApplication.class})
class SpringdataDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testInit() {
        System.out.println(redisTemplate.getConnectionFactory().getConnection().ping());
    }

    @Test
    public void testString(){
        redisTemplate.opsForValue().set("username","onejane");;
        System.out.println(redisTemplate.opsForValue().get("username"));
    }

}
