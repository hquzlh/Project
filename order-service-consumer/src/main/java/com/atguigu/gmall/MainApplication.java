package com.atguigu.gmall;

import com.atguigu.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @program: order-service-consumer
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-23 13:11
 **/

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = application.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("调用结束");
        System.in.read();
    }
}
