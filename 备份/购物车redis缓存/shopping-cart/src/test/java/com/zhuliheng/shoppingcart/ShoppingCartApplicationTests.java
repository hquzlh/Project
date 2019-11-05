package com.zhuliheng.shoppingcart;

import com.alibaba.fastjson.JSON;
import com.zhuliheng.shoppingcart.entities.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartApplicationTests {

    @Test
    public void contextLoads() {
        Jedis jedis=new Jedis("10.112.26.125",6379);
        System.out.println(jedis.ping());

        System.out.println(jedis.get("k1"));
    }

}
