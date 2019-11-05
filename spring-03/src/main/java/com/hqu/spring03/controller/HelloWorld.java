package com.hqu.spring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @program: spring-03
 * @description: hello测试
 * @author: Mr.Zhu
 * @create: 2019-08-28 13:59
 **/
@Controller
public class HelloWorld {
    /*@RequestMapping({"/","/index.html"})
    public  String index(){
        return "login";
    }*/
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello World";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("user", Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
