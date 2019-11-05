package com.dubbo.consumer;

import com.dubbo.api.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: consumer
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-11 15:54
 **/

public class Consumer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("dubbo服务消费端启动");
        DemoService demoService=(DemoService)context.getBean("demoService");
        String hello=demoService.sayHello("world");
        System.out.println(hello);
        System.in.read();

    }
}
