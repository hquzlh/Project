package com.zhuliheng.shoppingcart;

import com.alibaba.fastjson.JSON;
import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.util.JedisPoolUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartApplicationTests {

    @Test
    public void contextLoads() {
        JedisPool jedisPool= JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis1=jedisPool.getResource();
        Jedis jedis2=jedisPool.getResource();
    }

}
