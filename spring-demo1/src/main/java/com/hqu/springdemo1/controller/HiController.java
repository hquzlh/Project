package com.hqu.springdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: spring-demo1
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-26 08:55
 **/

@Controller
public class HiController {
    @RequestMapping("/hi")
    public String hi(){
        return "index";
    }
}
