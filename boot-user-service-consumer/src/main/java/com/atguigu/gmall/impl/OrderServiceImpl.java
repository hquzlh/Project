package com.atguigu.gmall.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.bean.UserAddress;
import com.atguigu.service.OrderService;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: order-service-consumer
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-23 10:44
 **/
@Service
public class OrderServiceImpl implements OrderService {
   @Reference
    UserService userService;
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id="+userId);
        List<UserAddress> addressList=userService.getUserAddressList(userId);

        return addressList;
    }
}
