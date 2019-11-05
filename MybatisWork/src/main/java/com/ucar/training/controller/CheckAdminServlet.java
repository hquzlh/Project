package com.ucar.training.controller;

import com.ucar.training.bean.User;
import com.ucar.training.service.admin.AdminService;
import com.ucar.training.service.admin.AdminServiceImp;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: final
 * @description: 检查管理员登陆
 * @author: Mr.Zhu
 * @create: 2019-08-05 21:19
 **/

public class CheckAdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname =req.getParameter("uname");
        String pwd=req.getParameter("pwd1");

        AdminService adminService=new AdminServiceImp();
        Boolean isExist=false;
        isExist=adminService.checkAdminSer(uname,pwd);

        ServletContext application=getServletContext();
        application.setAttribute("userList",adminService.selectUALl());
        application.setAttribute("adminList",adminService.selectAAll());
        getServletContext().setAttribute("boardList",adminService.selectMAll());
        if(isExist){
            resp.sendRedirect("/adminPages/Success1.jsp");
        }else {
            resp.sendRedirect("loginFail.jsp");
        }
    }
}
