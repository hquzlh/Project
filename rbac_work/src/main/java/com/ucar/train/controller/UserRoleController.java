package com.ucar.train.controller;

import com.ucar.train.domain.Role;
import com.ucar.train.domain.UserRole;
import com.ucar.train.service.RoleService;
import com.ucar.train.service.UserRoleService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-21 19:15
 **/
@Controller
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @RequestMapping("/insert")
    public String insertUserRole(int uid, HttpServletRequest request){
        String str=request.getParameter("role");
        UserRole userRole=new UserRole();
        userRole.setUid(uid);
        userRole.setRid(Integer.parseInt(str));
        userRoleService.deleteUserRole(uid);
        userRoleService.insertUserRole(userRole);
        return "redirect:/pages/userManage.html";
    }
    @RequestMapping("/delete")
    public void deleteUserRole(int uid){
        userRoleService.deleteUserRole(uid);
    }
    @ResponseBody
    @RequestMapping(value="/find",produces = "text/plain;charset=UTF-8")
    public String findUserRole(int uid){
        Role role=userRoleService.findUserRole(uid);
        JSONObject jsonObject=JSONObject.fromObject(role);
        return jsonObject.toString();
    }
    @RequestMapping("/default")
    public void defaultUserRole(int uid){
        userRoleService.defaultUserRole(uid);
    }
}
