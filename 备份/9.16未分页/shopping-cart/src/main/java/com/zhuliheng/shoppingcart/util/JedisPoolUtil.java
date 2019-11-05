package com.zhuliheng.shoppingcart.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: shopping-cart
 * @description: redis连接池
 * @author: Mr.Zhu
 * @create: 2019-09-09 10:12
 **/

public class JedisPoolUtil {
    private static volatile JedisPool jedisPool=null;
    private JedisPoolUtil(){}
    public static JedisPool getJedisPoolInstance(){
        if(jedisPool==null){
            synchronized (JedisPoolUtil.class){
                if (jedisPool==null){
                    JedisPoolConfig poolConfig=new JedisPoolConfig();
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(10*100);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool=new JedisPool("10.112.26.125",6379);
                }
            }
        }
        return jedisPool;
    }
    public static void release( Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }
}
