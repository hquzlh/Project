package hqu.zhuliheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springboot-quickly
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-23 14:25
 **/
@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!!";
    }
}
