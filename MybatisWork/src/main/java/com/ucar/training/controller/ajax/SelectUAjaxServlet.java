package com.ucar.training.controller.ajax;

import com.ucar.training.bean.User;

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
 * @description: ajax检验用户名重复
 * @author: Mr.Zhu
 * @create: 2019-08-06 11:08
 **/

public class SelectUAjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isExist=true;

            List<User> userList= (List<User>) getServletContext().getAttribute("userList");
            String uname=req.getParameter("uname");

        UserService userService=new UserServiceImp();
            if(userList!=null){
            isExist=userService.checkNameSer( uname);}


        if(isExist){
            resp.getWriter().write("很幸运呢，该用户名可以使用");
        }else {
            resp.getWriter().write("亲，该用户名已存在");
        }
    }
}
