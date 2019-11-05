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
    private String one_tag;
    private String two_tag;

    public Cart() {
    }

    public Cart( Integer uid, Integer gid, String name, Integer num, Integer price,String one_tag,String two_tag) {
        this.uid = uid;
        this.gid = gid;
        this.name = name;
        this.num = num;
        this.price = price;
        this.one_tag=one_tag;
        this.two_tag=two_tag;
    }
    public Cart(  Integer gid, String name, Integer num, Integer price,String one_tag,String two_tag) {
        this.gid = gid;
        this.name = name;
        this.num = num;
        this.price = price;
        this.one_tag=one_tag;
        this.two_tag=two_tag;
    }
}
