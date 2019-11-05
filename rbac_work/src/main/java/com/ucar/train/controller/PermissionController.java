package com.ucar.train.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.ucar.train.dao.PermissionDao;
import com.ucar.train.domain.Permission;
import com.ucar.train.domain.User;
import com.ucar.train.service.PermissionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-21 13:57
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ResponseBody
    @RequestMapping(value="findByMy",produces = "text/plain;charset=UTF-8")
    public String findPermissionByUid(HttpSession session){
        User user=(User)session.getAttribute("user");
        int uid=user.getUid();
        List<Permission> list=permissionService.findPerByUid(uid);
        JSONArray jsonArray= JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value="findAllPer",produces = "text/plain;charset=UTF-8")
    public String findAllPer(){
        List<Permission> list=permissionService.findAllPer();
        JSONArray jsonArray= JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    @RequestMapping("/insert")
     public String insertPer(Permission permission){
        permissionService.insertPer(permission);
        return "redirect:/pages/permissionManage.html";
     }
     @RequestMapping("/delete")
    public void deletePerByPid(int pid){
         permissionService.deletePerByPid(pid);
     }
     @RequestMapping("/update")
    public String updatePer(Permission permission)
     {
         permissionService.updatePer(permission);
         return "redirect:/pages/permissionManage.html";
    }
    @ResponseBody
    @RequestMapping(value="/findByPid",produces = "text/plain;charset=UTF-8")
     public String findByPid(int pid){
        Permission permission=permissionService.findByPid(pid);
        JSONObject jsonObject=JSONObject.fromObject(permission);
        return jsonObject.toString();
    }
}
