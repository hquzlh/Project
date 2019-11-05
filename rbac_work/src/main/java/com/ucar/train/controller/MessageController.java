package com.ucar.train.controller;

import com.ucar.train.domain.Message;
import com.ucar.train.domain.User;
import com.ucar.train.service.MessageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-20 16:51
 **/
@Controller("messageController")
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAllMessage(){
        List<Message> list=messageService.findAllMessage();
        JSONArray jsonArray=JSONArray.fromObject(list);
        return jsonArray.toString();
    };
    @RequestMapping("/insert")
    public String insertMessage(Message message, HttpSession session){
        User user=(User) session.getAttribute("user");
        message.setName(user.getUname());
        message.setDate(new Date());
        messageService.insertMessage(message);
        return "redirect:/pages/displayBoard.html";
    };
    @RequestMapping("/delete")
    public void deleteMessage(@RequestParam("id") Integer bid){

        messageService.deleteMessage(bid);
    };
    @RequestMapping("/update")
    public String updateMessage(Message message,HttpSession session){
        User user=(User) session.getAttribute("user");
        message.setName(user.getUname());
        message.setDate(new Date());
        messageService.updateMessage(message);
        return "redirect:/pages/displayBoard.html";
    };
    @ResponseBody
    @RequestMapping("findByBid")
    public String findByBid(int bid){

        Message message=messageService.findByBid(bid);

        JSONObject json = JSONObject.fromObject(message);
        return json.toString();
    }
}
