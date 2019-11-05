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
import com.zhuliheng.shoppingcart.util.CookieUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

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
    @RequestMapping("/login")
    public String login(User user,  HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User user1=userService.checkUser(user);
        if(user1!=null){
            session.setAttribute("user",user1);
            //登录成功判断cookie中是否有购物车，有则加入数据库
            List<Cart> cartList=null;
            String c = CookieUtil.getCookie(request,"cartList");

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
        User user= (User) session.getAttribute("user");
        userService.updateMoney(new UserMoneyDto(user.getUid(),money));
        return "redirect:/main.html";
    }

    @ResponseBody
    @RequestMapping("/getMoney")
    public String getMoney(HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null){
            List<Integer> str=new ArrayList<>();
            str.add(user.getMoney());
            return JSONArray.fromObject(str).toString();
        }else {
            List<String> str=new ArrayList<>();
            str.add("");
            return JSONArray.fromObject(str).toString();
        }
    }

}
