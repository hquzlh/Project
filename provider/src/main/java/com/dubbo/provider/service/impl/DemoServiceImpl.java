package com.dubbo.provider.service.impl;

import com.dubbo.api.service.DemoService;

/**
 * @program: provider
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-11 15:37
 **/

public class DemoServiceImpl  implements DemoService {
    @Override
    public String sayHello(String s) {
        return "hello"+s;
    }
}
