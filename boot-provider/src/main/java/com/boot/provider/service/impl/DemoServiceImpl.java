package com.boot.provider.service.impl;

import com.dubbo.api.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @program: provider
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-11 15:37
 **/
@Service
@com.alibaba.dubbo.config.annotation.Service(version = "1.0")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String s) {

        return "hello"+s;
    }
}
