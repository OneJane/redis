package com.onejane;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 连接池工具类
 */
public class JedisPoolConnectRedis {
    private static JedisPool jedisPool;
    static {
        // 创建连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数 默认8
        jedisPoolConfig.setMaxTotal(5);
        // 设置最大空闲数量 默认8
        jedisPoolConfig.setMaxIdle(5);
        // 设置最少空闲数量 默认0
        jedisPoolConfig.setMinIdle(0);
        // 设置等待时间 ms
        jedisPoolConfig.setMaxWaitMillis(100);
        // 初始化 JedisPool 对象
        jedisPool = new JedisPool(jedisPoolConfig,"172.28.128.3",6379,100);
//        jedisPool = new JedisPool(jedisPoolConfig,"172.28.128.3",6379,100,"123456");
    }

    /**
     * 获取jedis对象
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
