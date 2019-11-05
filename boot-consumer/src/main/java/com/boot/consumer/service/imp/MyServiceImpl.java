package com.boot.consumer.service.imp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @program: boot-consumer
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-12 10:13
 **/


@Service
public class MyServiceImpl
{
    @Reference(version = "1.0")
   private   DemoService demoService;

    public String sayHello(String s) {
        return demoService.sayHello(s);
    }
}

