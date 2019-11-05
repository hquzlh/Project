package com.boot.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.consumer.service.imp.MyServiceImpl;
import com.dubbo.api.service.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-consumer
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-12 10:14
 **/
@RestController
public class DemoController {

    @Autowired
    MyServiceImpl myService;


    @RequestMapping("/init")
    public String initOrder(@RequestParam("s") String s){

        return myService.sayHello(s);
    }
}
