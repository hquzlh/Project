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
 * @description: 检验管理员用户名重复
 * @author: Mr.Zhu
 * @create: 2019-08-06 12:44
 **/

public class SelectAAjaxServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isExist = true;

        //List<User> adminList= (List<User>) getServletContext().getAttribute("adminList");
        String uname = req.getParameter("uname");

        /*AdminService adminService=new AdminServiceImp();
        if(adminList!=null){
        isExist=adminService.checkNameSer( uname,adminList);}

        if(isExist){
            resp.getWriter().write("很幸运呢，该用户名可以使用");
        }else {
            resp.getWriter().write("亲，该用户名已存在");
        }*/
        AdminService adminService = new AdminServiceImp();

        isExist = adminService.checkNameSer(uname);


        if (isExist) {
            resp.getWriter().write("很幸运呢，该用户名可以使用");
        } else {
            resp.getWriter().write("亲，该用户名已存在");
        }
    }
}
