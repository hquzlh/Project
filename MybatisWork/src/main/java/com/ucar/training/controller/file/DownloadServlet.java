package com.ucar.training.controller.file;

import com.sun.deploy.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @program: final
 * @description: 下载文件
 * @author: Mr.Zhu
 * @create: 2019-08-07 15:01
 **/

public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename=req.getParameter("filename");
        String path="D:\\final\\src\\main\\webapp\\WEB-INF\\upload";
        InputStream in=new FileInputStream(new File(path,filename));
        //谷歌和ie浏览器方式是URLEncode方式
        String name=null;
        if(req.getHeader("User-Agent").contains("MSIE")){
            name= URLEncoder.encode(filename,"UTF-8");
        }else {
            //火狐浏览器是 iso-8859-1
            name=new String(filename.getBytes("UTF-8"),"iso-8859-1");
        }
        //告诉浏览器用下载方式打开
        resp.setContentType("application/x-msdownload");
        //告诉浏览器下载文件的名称
        resp.setHeader("Content-Disposition","attachment;filename="+name);
        //把读取的数据写给浏览器
        Files.copy(Paths.get(path+"/"+filename),resp.getOutputStream());

    }
}

