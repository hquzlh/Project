package com.zhuliheng.shoppingcart.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonView;
import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.UserMoneyDto;
import com.zhuliheng.shoppingcart.exception.MyException;
import com.zhuliheng.shoppingcart.service.CartService;
import com.zhuliheng.shoppingcart.service.GoodsService;
import com.zhuliheng.shoppingcart.service.UserService;
import com.zhuliheng.shoppingcart.util.CodeUtil;
import com.zhuliheng.shoppingcart.util.CookieUtil;
import com.zhuliheng.shoppingcart.util.JedisPoolUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-02 15:54
 **/

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
     private UserService userService;
    @Autowired
    private CartService cartService;
    JedisPool jedisPool= JedisPoolUtil.getJedisPoolInstance();

    @RequestMapping("/login")
    public String login(User user,  HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User user1=userService.checkUser(user);
        if(user1!=null){
            session.setAttribute("user",user1);
            //登录成功判断redis中是否有购物车，有则加入数据库
            List<Cart> cartList=null;
            List<Cart> carts=null;
            //默认购物车无
            Boolean tag=true;
            carts=cartService.findAllCart(user.getUid());
            Jedis jedis=jedisPool.getResource();
            String c= CodeUtil.decode(jedis.get("cartList"));
            if(!"".equals(c)){
                cartList= JSON.parseArray(c,Cart.class);
                if(cartList!=null) {
                    for (Cart cart : cartList) {
                        cart.setUid(user1.getUid());
                        for (Cart cart1 : carts) {
                            if(cart1.getGid().equals(cart.getGid())){
                                tag=true;
                            }
                        }if(tag){
                            cartService.insertCart(cart);
                        }else {
                            for (int i = 0; i < cart.getNum(); i++) {
                                cartService.insertCart(cart);
                            }

                        }
                    }
                    cartList=null;
                    jedis.set("cartList", CodeUtil.encode(cartList));
                }
            }
            JedisPoolUtil.release(jedis);
            return "redirect:/main.html";
        }else {
            request.setAttribute("msg","用户名密码错误");
            return "login";
        }
    }
    @ResponseBody
    @RequestMapping("/getName")
    public String getName(HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            List<String> str=new ArrayList<>();
            str.add(user.getName());
            return JSONArray.fromObject(str).toString();
        }else {
            List<String> str=new ArrayList<>();
            str.add("未登录");
            return JSONArray.fromObject(str).toString();
        }
    }
    @RequestMapping("/logout")
    @ResponseBody
    public  String logout(HttpSession session){
        session.removeAttribute("user");

        List<String> str=new ArrayList<>();
        str.add("退出");
        return JSONArray.fromObject(str).toString();
    }


    @RequestMapping("/deposit")
    public String deposit(Integer money,HttpSession session){
        if(money<0){
            return "redirect:/main.html";
        }
        User user= (User) session.getAttribute("user");
        userService.updateMoney(new UserMoneyDto(user.getUid(),money));
        return "redirect:/main.html";
    }

    @ResponseBody
    @RequestMapping("/getMoney")
    public String getMoney(HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
           Integer money=userService.getMoney(user.getUid());
           String myMoney=""+money+"";
            return myMoney;
        }else {

            return "空";
        }
    }

}
