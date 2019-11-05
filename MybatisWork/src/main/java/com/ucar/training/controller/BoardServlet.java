package com.ucar.training.controller;

import com.ucar.training.bean.Message;
import com.ucar.training.service.user.UserService;
import com.ucar.training.service.user.UserServiceImp;
import com.ucar.training.util.GetDate;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: final
 * @description: 留言板信息处理
 * @author: Mr.Zhu
 * @create: 2019-08-07 08:35
 **/

public class BoardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取留言板信息
        String message=(String) req.getAttribute("mess1");
        System.out.println(message);
        ServletContext application=getServletContext();
        //获取登陆的用户名
        String uname=(String)req.getSession().getAttribute("uname");
        Message message1=new Message();
        message1.setDate(GetDate.getDate());
        message1.setMessage(message);
        message1.setName(uname);
        UserService userService=new UserServiceImp();
        userService.messageSer(message1);

        application.setAttribute("boardList",userService.selectMAll());
        application.setAttribute("boardList",userService.selectMAll());
        resp.sendRedirect("/userPages/messageBoard1.jsp");
    }
}
