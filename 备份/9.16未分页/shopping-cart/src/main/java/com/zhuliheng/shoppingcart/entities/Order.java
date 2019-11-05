package com.zhuliheng.shoppingcart.entities;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description: 订单
 * @author: Mr.Zhu
 * @create: 2019-09-09 14:32
 **/
@Data
public class Order {
    private Integer id;
    private Integer uid;
    private Integer gid;
    private Integer num;
    private Integer orderNumber;
    private String date;

    public Order() {
    }

    public Order(Integer uid, Integer gid, Integer num, Integer orderNumber, String date) {
        this.uid = uid;
        this.gid = gid;
        this.num = num;
        this.orderNumber = orderNumber;
        this.date = date;
    }
}
