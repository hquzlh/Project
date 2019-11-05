package com.zhuliheng.shoppingcart.util;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.URLEncoder;
import com.zhuliheng.shoppingcart.entities.Cart;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @program: shopping-cart
 * @description: 字符转换
 * @author: Mr.Zhu
 * @create: 2019-09-09 10:30
 **/

public class CodeUtil {
    public static String encode(List list)  {
        String str="";
        if(list!=null){
            try {
                str=URLEncoder.encode(JSON.toJSONString(list),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return str;
    }
    public static String decode(String json){
        String str="";
        if(json!=null){
            try {
                str=URLDecoder.decode(json, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return str;
    }
}
