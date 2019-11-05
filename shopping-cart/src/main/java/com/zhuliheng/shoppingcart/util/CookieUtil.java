package com.zhuliheng.shoppingcart.util;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.URLEncoder;
import com.zhuliheng.shoppingcart.entities.Cart;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-03 20:21
 **/

public class CookieUtil {


    public static String getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        String carts=null;
        for(Cookie cookie:cookies){

            if(cookie.getName().equals(name)){
                try {
                   carts=URLDecoder.decode(cookie.getValue(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }
        return carts;
    }
    public static void addCookie(HttpServletResponse response,List<Cart> cartList){
        String carts= null;
        try {
            carts = URLEncoder.encode(JSON.toJSONString(cartList),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Cookie cookie=new Cookie("cartList", carts);
        //三小时过期
        cookie.setMaxAge(60*60*3);
        response.addCookie(cookie);
    }


}
