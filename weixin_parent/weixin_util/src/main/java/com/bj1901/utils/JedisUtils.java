package com.bj1901.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis操作redis的工具类
 * @Author: adming
 * @Date: 2019/5/7 0007 10:20
 */
public class JedisUtils {

    // 定义redis数据库连接池变量
    private static JedisPool jp;

    // 使用静态代码块对加载资源
    static {
        // 获取输入流
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");

        // 定义properties对象加载文件
        Properties prop = new Properties();
        try {
            prop.load(is);
            // 定义数据库连接池配置对象
            JedisPoolConfig jpConfig = new JedisPoolConfig();
            jpConfig.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
            jpConfig.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));

            // 初始化连接池对象
            int port = Integer.parseInt(prop.getProperty("port"));
            jp = new JedisPool(jpConfig, prop.getProperty("host"), port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取操作redis的对象
     * @return
     */
    public static Jedis getJedis() {
        return jp.getResource();
    }

    /**
     * 获取redis数据库的连接池对象
     * @return
     */
    public static JedisPool getJedisPool() {
        return jp;
    }

    /**
     * 归还Jedis对象到连接池中
     * @param jedis
     */
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
