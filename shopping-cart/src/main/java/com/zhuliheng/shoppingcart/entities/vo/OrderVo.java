package com.zhuliheng.shoppingcart.entities.vo;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-09 15:22
 **/
@Data
public class OrderVo {
    private String uri;
    private Integer uid;
    private Integer gid;
    private String name;
    private Integer price;
    private Integer num;
    private Integer orderNumber;
    private String date;

    public OrderVo() {
    }

    public OrderVo(String uri, Integer uid, Integer gid, String name, Integer price, Integer num, Integer orderNumber, String date) {
        this.uri = uri;
        this.uid = uid;
        this.gid = gid;
        this.name = name;
        this.price = price;
        this.num = num;
        this.orderNumber = orderNumber;
        this.date = date;
    }
}
