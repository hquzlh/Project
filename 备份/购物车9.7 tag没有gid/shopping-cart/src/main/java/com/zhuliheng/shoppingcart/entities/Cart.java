package com.zhuliheng.shoppingcart.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: shopping-cart
 * @description: 订单
 * @author: Mr.Zhu
 * @create: 2019-09-02 13:51
 **/
@Data
public class Cart implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer gid;
    private String name;
    private Integer num;
    private Integer price;


    public Cart() {
    }

    public Cart( Integer uid, Integer gid, String name, Integer num, Integer price) {
        this.uid = uid;
        this.gid = gid;
        this.name = name;
        this.num = num;
        this.price = price;

    }
    public Cart(  Integer gid, String name, Integer num, Integer price) {
        this.gid = gid;
        this.name = name;
        this.num = num;
        this.price = price;

    }
}
