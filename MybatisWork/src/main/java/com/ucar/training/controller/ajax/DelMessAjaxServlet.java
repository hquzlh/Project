package com.ucar.training.controller.ajax;

import com.ucar.training.bean.Message;
import com.ucar.training.service.admin.AdminService;
import com.ucar.training.service.admin.AdminServiceImp;
import com.ucar.training.service.user.UserService;
import com.ucar.training.service.user.UserServiceImp;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: final
 * @description: 删除留言
 * @author: Mr.Zhu
 * @create: 2019-08-07 09:55
 **/

public class DelMessAjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String date=req.getParameter("date");


        AdminService adminService=new AdminServiceImp();
        adminService.deleteMSer(name,date);
        getServletContext().setAttribute("boardList",adminService.selectMAll());

        resp.sendRedirect("/adminPages/deleteBoard.jsp");
    }
}
