package com.ucar.train.service.impl;

import com.ucar.train.service.IAccountService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * @program: spring
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-17 19:48
 **/
@Component
public class AccountServiceImpl3 implements IAccountService {

    public void saveAccount() {
        System.out.println("保存对象成功");
    }
    @PostConstruct
    public void init() {
        System.out.println("出生");
    }
    @PreDestroy
    public void destory() {
        System.out.println("销毁");
    }
}
