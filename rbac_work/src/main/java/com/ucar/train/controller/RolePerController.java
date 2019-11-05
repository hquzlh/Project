package com.ucar.train.controller;

import com.ucar.train.domain.Permission;
import com.ucar.train.domain.RolePermission;
import com.ucar.train.service.RolePerService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-21 14:31
 **/
@Controller
@RequestMapping("/roleper")
public class RolePerController {
    @Autowired
    private RolePerService rolePerService;

    @ResponseBody
    @RequestMapping(value = "/findByRid",produces = "text/plain;charset=UTF-8")
    public String findbyRid(int rid){
        List<Permission> list=rolePerService.findPermissionByRid(rid);
        JSONArray jsonArray=JSONArray.fromObject(list);
        return jsonArray.toString();

    }
    @RequestMapping("/delete")
     public void deletePermissionByRid(int rid){
        rolePerService.deletePermissionByRid(rid);
     }
     @RequestMapping("/insert")
     public String insertPermission(HttpServletRequest request,int rid){
        rolePerService.deletePermissionByRid(rid);
        String[] str= request.getParameterValues("per");
        List<RolePermission> list=new ArrayList<>();
         for (int i = 0; i < str.length; i++) {

             RolePermission rolePermission=new RolePermission();
             rolePermission.setRid(rid);
             rolePermission.setPid(Integer.parseInt(str[i]));
             list.add(rolePermission);
         }
         for (RolePermission rolePermission : list) {
             rolePerService.insertPermission(rolePermission);
         }
         return "redirect:/pages/roleManage.html";
     }
}
