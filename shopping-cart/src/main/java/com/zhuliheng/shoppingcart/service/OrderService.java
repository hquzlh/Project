package com.zhuliheng.shoppingcart.service;

import com.zhuliheng.shoppingcart.entities.Order;
import com.zhuliheng.shoppingcart.entities.vo.OrderVo;

import java.util.List;

public interface OrderService {
    /**
     * 查找用户的所有订单信息
     * @param uid 用户id
     * @return 订单信息
     */
    public List<Order> findOrderByUid(Integer uid);

    /**
     * 新增订单
     * @param order 订单信息
     */
    public void insert(Order order);

    /**
     * 查找当前订单号
     * @return 订单号
     */
    public Integer findOrderNumber();
    public List<OrderVo> findAll(Integer uid);
}
