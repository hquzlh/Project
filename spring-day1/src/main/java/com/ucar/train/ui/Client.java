package com.ucar.train.ui;

import com.ucar.train.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

/**
 * @program: spring
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-17 20:04
 **/

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountServiceImpl3",IAccountService.class);
        /*IAccountService as2=ac.getBean("accountService2",IAccountService.class);*/
        as.saveAccount();

    }
}
