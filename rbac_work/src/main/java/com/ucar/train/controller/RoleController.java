package com.ucar.train.controller;

import com.ucar.train.domain.Role;
import com.ucar.train.service.RoleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: rbac_work
 * @description: 角色
 * @author: Mr.Zhu
 * @create: 2019-08-20 21:17
 **/
@Controller("roleController")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value ="findAllRole",produces = "text/plain;charset=UTF-8")
    public String  findAllRole(){
        List<Role> list=roleService.findAllRole();
        JSONArray jsonArray=JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @RequestMapping("insert")
    public String insertRole(Role role){
        roleService.insertRole(role);
        return "redirect:/pages/main.html";
    }

    @RequestMapping("update")
    public String updateRole(Role role){
        roleService.updateRole(role);
        return "redirect:/pages/main.html";
    }

    @RequestMapping("delete")
    public void deleteRole(int rid){
        roleService.deleteRole(rid);
    }

    @ResponseBody
    @RequestMapping(value="findByRid",produces = "text/plain;charset=UTF-8")
    public String findByRid(int rid){
        Role role=roleService.findByRid(rid);
        JSONObject jsonObject=JSONObject.fromObject(role);
        return jsonObject.toString();
    }
}
