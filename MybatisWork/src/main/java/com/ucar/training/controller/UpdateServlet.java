package com.ucar.training.controller;

import com.ucar.training.bean.User;
import com.ucar.training.service.admin.AdminService;
import com.ucar.training.service.admin.AdminServiceImp;
import com.ucar.training.service.user.UserService;
import com.ucar.training.service.user.UserServiceImp;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @program: final
 * @description: 用户信息的修改
 * @author: Mr.Zhu
 * @create: 2019-08-06 16:31
 **/

public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User newUser=new User();
        newUser.setUname(req.getParameter("uname"));
        newUser.setTname(req.getParameter("tname"));
        newUser.setSex(req.getParameter("sex"));
        newUser.setAge(req.getParameter("age"));
        newUser.setEmail(req.getParameter("email"));
        newUser.setTel(req.getParameter("tel"));
        newUser.setPwd(req.getParameter("pwd1"));
        newUser.setHobby(req.getParameterValues("hobby"));
        newUser.setHobbyStr(Arrays.toString(req.getParameterValues("hobby")));
        newUser.setIsAdmin(false);
        AdminService adminService=new AdminServiceImp();
        adminService.updateSer(newUser);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getServletContext().setAttribute("userList",adminService.selectUALl());
        //还需要页面跳转
        resp.sendRedirect("/adminPages/userMessage1.jsp");

    }
}
