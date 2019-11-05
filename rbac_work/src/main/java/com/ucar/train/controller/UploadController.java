package com.ucar.train.controller;

import com.sun.deploy.util.SessionState;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @program: rbac_work
 * @description: 文件上传
 * @author: Mr.Zhu
 * @create: 2019-08-22 14:20
 **/
@Controller
@RequestMapping("/file")
public class UploadController {
    @RequestMapping("/upload")
    public String fileUpload(HttpServletRequest request, @RequestParam(value="upload",required=false)MultipartFile upload) throws Exception{
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename=upload.getOriginalFilename();
        String uuid= UUID.randomUUID().toString().replace(("-"),"");
        filename=uuid+"_"+filename;
        upload.transferTo(new File(path,filename));
        return "success";
    }
    //跨服务器上传
    @RequestMapping("/upload1")
    public String fileUpload1( MultipartFile upload1) throws Exception{
        String path="http://10.112.26.120:80/upload/";
        String filename=upload1.getOriginalFilename();
        String uuid= UUID.randomUUID().toString().replace(("-"),"");
        filename=uuid+"_"+filename;
        Client client=Client.create();
        WebResource resource = client.resource(path + filename);
        resource.put(upload1.getBytes());
        return "success";
    }
}
