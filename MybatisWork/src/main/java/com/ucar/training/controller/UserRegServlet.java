package com.ucar.training.controller;

import com.ucar.training.bean.User;
import com.ucar.training.service.admin.AdminService;
import com.ucar.training.service.admin.AdminServiceImp;
import com.ucar.training.service.user.UserService;
import com.ucar.training.service.user.UserServiceImp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: final
 * @description: 普通用户注册
 * @author: Mr.Zhu
 * @create: 2019-08-05 17:10
 **/

public class UserRegServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //处理请求信息
        User user= new User();
        user.setAge(req.getParameter("age"));
        user.setEmail(req.getParameter("email"));
        user.setPwd(req.getParameter("pwd1"));
        user.setSex(req.getParameter("sex"));
        user.setTel(req.getParameter("tel"));
        user.setTname(req.getParameter("tname"));
        user.setUname(req.getParameter("uname"));
        user.setHobby(req.getParameterValues("hobby"));
        user.setHobbyStr(Arrays.toString(req.getParameterValues("hobby")));
        user.setIsAdmin(false);
        ServletContext application=getServletContext();
        UserService userService=new UserServiceImp();
        userService.insertUser(user);


        //页面重定向
        application.setAttribute("userList",userService.selectAll());
        if(req.getParameter("insertUser")!=null){
            AdminService adminService=new AdminServiceImp();
            application.setAttribute("userList",adminService.selectUALl());
            resp.sendRedirect("/adminPages/userMessage1.jsp");
        }else {
        resp.sendRedirect("/userPages/userLogin.jsp");}

    }
}
