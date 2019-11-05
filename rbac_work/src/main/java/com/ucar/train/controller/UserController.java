package com.ucar.train.controller;

import com.ucar.train.domain.User;
import com.ucar.train.domain.UserRole;
import com.ucar.train.exception.LoginException;
import com.ucar.train.service.UserRoleService;
import com.ucar.train.service.UserService;
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
 * @create: 2019-08-20 10:02
 **/
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/findAllUser")
    public String findAllUser(){
        List<User> list= userService.findAllUser();
        JSONArray jsonArray=JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    @RequestMapping("/register")
    public String register(User user) {
        if (userService.insertUser(user)){
            UserRole userRole=new UserRole();
            userRoleService.defaultUserRole(user.getUid());
            return "redirect:/login.html";
        }
        return "redirect:/register.html";
    }
    @RequestMapping("/insert")
    public String insertUser(User user) {
        userService.insertUser(user);
        UserRole userRole=new UserRole();
        userRoleService.defaultUserRole(user.getUid());;
        return "redirect:/pages/main.html";
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session) throws LoginException {
        try {
            User user1=userService.findByNameAndPassword(user);
            if (user.getUname().equals(user1.getUname())){
                session.setAttribute("user",user1);
                return "redirect:/pages/main.html";
            }
        } catch (Exception e) {
            e.printStackTrace();

            throw  new LoginException();
        }
        return "redirect:/login.html";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login.html";
    }
    @ResponseBody
    @RequestMapping("/findMyUser")
    public String findMyUser(HttpSession session){
        User user=(User)session.getAttribute("user");
        JSONObject jsonObject=JSONObject.fromObject(user);
        return jsonObject.toString();
    }


    @RequestMapping("/update")
    public  String update(User user){
        userService.updateUser(user);
        return  "redirect:/pages/user/displayUser.html";
    }

    @RequestMapping("/findByUid")
    @ResponseBody
    public String findByUid(int uid){
        User user=userService.findByUid(uid);
        JSONObject jsonObject=JSONObject.fromObject(user);
        return jsonObject.toString();
    }

    @RequestMapping("/delete")
    public void delete(int uid){
        userService.deleteByUid(uid);
    }
}
