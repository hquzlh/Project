package com.ucar.training.controller;

import com.ucar.training.bean.User;

import com.ucar.training.service.user.UserService;
import com.ucar.training.service.user.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @program: final
 * @description: 检查普通用户登陆
 * @author: Mr.Zhu
 * @create: 2019-08-05 20:36
 **/

public class CheckUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname =req.getParameter("uname");
        String pwd=req.getParameter("pwd1");
        HttpSession session=req.getSession();

        UserService userService=new UserServiceImp();
        Boolean isExist=false;
        isExist=userService.checkUserSer(uname,pwd);

        getServletContext().setAttribute("userList",userService.selectAll());
        getServletContext().setAttribute("boardList",userService.selectMAll());
        if(isExist){

            resp.sendRedirect("userPages/Success2.jsp");
            session.setAttribute("uname",uname);
        }else {
            resp.sendRedirect("loginFail.jsp");
        }
    }
}