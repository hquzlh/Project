package com.zhuliheng.shoppingcart;

import com.alibaba.fastjson.JSON;
import com.zhuliheng.shoppingcart.entities.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartApplicationTests {

    @Test
    public void contextLoads() {
        List<Cart> list=new ArrayList<>();

        String json=JSON.toJSONString(list);
        System.out.println(json);
        System.out.println(JSON.parseArray(json,Cart.class));
    }

}
