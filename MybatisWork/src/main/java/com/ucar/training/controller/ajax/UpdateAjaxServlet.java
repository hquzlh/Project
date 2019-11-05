package com.ucar.training.controller.ajax;

import com.ucar.training.bean.User;
import com.ucar.training.service.admin.AdminService;
import com.ucar.training.service.admin.AdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: final
 * @description: ajax更新用户
 * @author: Mr.Zhu
 * @create: 2019-08-06 11:09
 **/

public class UpdateAjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService=new AdminServiceImp();
        User user=adminService.selectUser(req.getParameter("uname"));

        req.setAttribute("updateUser",user);
        req.getRequestDispatcher("adminPages/update.jsp").forward(req,resp);
    }
}
