package com.ucar.training.controller;

import com.ucar.training.bean.User;
import com.ucar.training.service.admin.AdminService;
import com.ucar.training.service.admin.AdminServiceImp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: final
 * @description: 管理员注册
 * @author: Mr.Zhu
 * @create: 2019-08-05 17:11
 **/
public class AdminRegServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理注册页面的信息
            //处理注册页面的信息
            //设置请求编码格式
            //req.setCharacterEncoding("utf-8");
            //设置响应编码格式
            //resp.setCharacterEncoding("utf-8");
           // resp.setContentType("text/html;charset=utf-8");
            //处理请求信息
            User admin= new User();
            admin.setAge(req.getParameter("age"));
            admin.setEmail(req.getParameter("email"));
            admin.setPwd(req.getParameter("pwd1"));
            admin.setSex(req.getParameter("sex"));
            admin.setTel(req.getParameter("tel"));
            admin.setTname(req.getParameter("tname"));
            admin.setUname(req.getParameter("uname"));
            admin.setHobby(req.getParameterValues("hobby"));
            admin.setHobbyStr(Arrays.toString(req.getParameterValues("hobby")));
            admin.setIsAdmin(true);
            AdminService adminService=new AdminServiceImp();
            adminService.insertSer(admin);


        //页面重定向
            resp.sendRedirect("adminPages/adminLogin.jsp");

        }


}

