package com.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @program: provider
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-11 15:44
 **/

public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.out.println("dubbo服务端已启动");
        System.in.read();
    }
}
