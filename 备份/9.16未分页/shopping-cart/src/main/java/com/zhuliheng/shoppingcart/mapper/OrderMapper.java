package com.zhuliheng.shoppingcart.mapper;

import com.zhuliheng.shoppingcart.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-09 14:39
 **/
@Repository
public interface OrderMapper {
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

    /**
     * 模糊查找订单
     * @param name 商品名
     * @return 订单信息
     */
    public List<Order> findOrderByName(String name);
}
