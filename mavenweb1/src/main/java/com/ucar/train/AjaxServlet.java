package com.ucar.train;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: mavenweb1
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-01 16:00
 **/

public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求信息
        //处理请求信息
        //响应处理结果
        resp.getWriter().write("var obj={name:'张三',pwd:123}");
    }
}
