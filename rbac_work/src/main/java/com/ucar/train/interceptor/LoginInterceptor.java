package com.ucar.train.interceptor;

import com.ucar.train.exception.LoginException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: rbac_work
 * @description: 登录检测
 * @author: Mr.Zhu
 * @create: 2019-08-22 16:36
 **/

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute("user")==null){
            System.out.println("有执行");
            return  false;
        };
        return true;
    }
}
