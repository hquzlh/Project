package com.zhuliheng.shoppingcart.entities.dto;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description: 商品数量对象
 * @author: Mr.Zhu
 * @create: 2019-09-02 14:27
 **/
@Data
public class GoodsNumDto {
    private Integer gid;
    private Integer num;

    public GoodsNumDto() {
    }

    public GoodsNumDto(Integer gid, Integer num) {
        this.gid = gid;
        this.num = num;
    }
}
