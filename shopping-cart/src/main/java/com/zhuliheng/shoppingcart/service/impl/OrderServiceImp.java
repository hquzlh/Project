package com.zhuliheng.shoppingcart.service.impl;

import com.zhuliheng.shoppingcart.entities.Order;
import com.zhuliheng.shoppingcart.entities.vo.OrderVo;
import com.zhuliheng.shoppingcart.mapper.OrderMapper;
import com.zhuliheng.shoppingcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-09 14:37
 **/
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> findOrderByUid(Integer uid) {
        return orderMapper.findOrderByUid(uid);
    }

    @Override
    public void insert(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public Integer findOrderNumber() {
        return orderMapper.findOrderNumber();
    }

    @Override
    public List<OrderVo> findAll(Integer uid) {
        return orderMapper.findAll(uid);
    }
}
