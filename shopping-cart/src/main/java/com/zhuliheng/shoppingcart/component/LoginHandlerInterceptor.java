package com.zhuliheng.shoppingcart.component;

import com.zhuliheng.shoppingcart.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shopping-cart
 * @description: 登陆校验
 * @author: Mr.Zhu
 * @create: 2019-09-04 16:23
 **/
@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /*@Bean
    public LoginHandlerInterceptor getMyInterceptor() {
        return new LoginHandlerInterceptor();
    }*/


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user= (User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("msg","此操作需要先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }

}
