package com.onejane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    Jedis jedis = null;
    @Before
    public void testInit(){
        jedis = new Jedis("172.28.128.3",6379);
//        jedis.auth("123456");
        String pong = jedis.ping();
        System.out.println(pong);
    }


    @Test
    public void testString(){
        System.out.println(jedis.select(2));
        System.out.println(jedis.set("username","onejane"));
        System.out.println(jedis.get("username"));
        jedis.set("user:name:1","j");
        System.out.println(jedis.get("user:name:1"));
    }
    @Test
    public void testKeys(){
        System.out.println(jedis.select(2));
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.flushAll());
    }



    @After
    public void close(){
        if(null != jedis){
            jedis.close();
        }
    }
}
