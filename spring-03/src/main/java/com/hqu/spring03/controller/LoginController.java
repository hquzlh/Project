package com.hqu.spring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: spring-03
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-29 09:18
 **/

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(String username, String password , Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
