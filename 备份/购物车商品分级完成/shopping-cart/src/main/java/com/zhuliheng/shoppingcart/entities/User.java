package com.zhuliheng.shoppingcart.entities;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description: 用户
 * @author: Mr.Zhu
 * @create: 2019-09-02 13:51
 **/
@Data
public class User {
    private Integer uid;
    private String name;
    private String password;
    private Integer money;

}
