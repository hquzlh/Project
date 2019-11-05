package com.zhuliheng.shoppingcart.entities.dto;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description: 用户金额对象
 * @author: Mr.Zhu
 * @create: 2019-09-02 14:18
 **/
@Data
public class UserMoneyDto {
    private Integer uid;
    private String name;
    private Integer money;

    public UserMoneyDto(Integer uid, Integer money) {
        this.uid = uid;
        this.money = money;
    }

    public UserMoneyDto(Integer uid, String name, Integer money) {
        this.uid = uid;
        this.name = name;
        this.money = money;
    }

    public UserMoneyDto() {
    }
}
