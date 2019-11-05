package com.ucar.training.controller.file;

import com.ucar.training.util.GetDate;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @program: final
 * @description: 文件上传
 * @author: Mr.Zhu
 * @create: 2019-08-07 11:05
 **/

public class UploadServlet extends HttpServlet {
    @Override
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            // 使用默认配置创建解析器工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 获取解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 是否为multipart/form-data类型
            if (!upload.isMultipartContent(request)) {
                return;
            }
            // 解析request的输入流
            List<FileItem> fileItemList = upload.parseRequest(request);
            // 遍历list集合
            for (FileItem fileItem : fileItemList) {
                if (fileItem.isFormField()) {
                    // 普通字段
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    System.out.println(name + "=" + value);
                } else {
                    // 上传文件
                    // 获取上传文件名
                    String fileName = fileItem.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                    // 获取输入流
                    in = fileItem.getInputStream();
                    // 获取上传文件目录
                    String savePath = "D:\\final\\src\\main\\webapp\\WEB-INF\\upload";
                    // 上传文件名若不存在, 则先创建
                    File savePathDir=new File(savePath);
                    if (!savePathDir.exists()) {
                        savePathDir.mkdir();
                    }
                    // 获取输出流
                    out = new FileOutputStream(savePath + "\\" + fileName);
                    System.out.println(savePath + "\\" + fileName);
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    while((len=in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        response.sendRedirect("/adminPages/adminMain.jsp");}

}
