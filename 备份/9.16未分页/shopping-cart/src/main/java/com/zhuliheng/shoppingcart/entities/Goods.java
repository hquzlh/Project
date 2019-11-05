package com.zhuliheng.shoppingcart.entities;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description: 商品
 * @author: Mr.Zhu
 * @create: 2019-09-02 13:51
 **/
@Data
public class Goods {
    private Integer gid;
    private String name;
    private Integer price;
    private Integer num;
    private String uri;

    public Goods(Integer gid, String name, Integer price, Integer num,  String uri) {
        this.gid = gid;
        this.name = name;
        this.price = price;
        this.num = num;

        this.uri = uri;
    }

    public Goods() {
    }
}
