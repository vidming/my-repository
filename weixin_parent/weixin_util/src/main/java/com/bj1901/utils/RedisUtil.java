package com.bj1901.utils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @Author: adming
 * @Date: 2019/6/12 0012 10:56
 */
public class RedisUtil {

    private static Jedis jedis = JedisUtils.getJedis();

    /**
     * 对象序列化存储进redis
     * @param key ： 设置的键
     * @param value ： 序列化存储的对象
     * @param timeOut ： 缓存时间
     */
    public static void save(String key, String value, int timeOut) {
        jedis.set(key, value);
        // 设置缓存时间
        jedis.setex(key, timeOut, value);
    }

    /**
     * 对象序列化存储进redis 默认设置
     * @param key ： 设置的键
     * @param value ： 序列化存储的值
     */
    public static void save(String key, String value) {
        jedis.set(key, value);
    }

    /**
     * 通过指定的key获取redis中缓冲的对象
     * @param key ： 指定的键值
     * @return
     */
    public static String get(String key) {
        return jedis.get(key);
    }

}
