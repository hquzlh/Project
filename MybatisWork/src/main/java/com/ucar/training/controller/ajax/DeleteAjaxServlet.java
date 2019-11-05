package com.ucar.training.controller.ajax;

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
import java.util.List;

/**
 * @program: final
 * @description: ajax删除用户
 * @author: Mr.Zhu
 * @create: 2019-08-06 11:09
 **/

public class DeleteAjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getParameter("uname");
        AdminService adminService=new AdminServiceImp();
        adminService.deleteSer(uname);
        ServletContext application=getServletContext();
        application.setAttribute("userList",adminService.selectUALl());

        resp.getWriter().write("删除成功");
    }
}
