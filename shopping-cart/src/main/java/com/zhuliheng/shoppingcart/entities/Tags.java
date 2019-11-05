package com.zhuliheng.shoppingcart.entities;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-05 15:55
 **/
@Data
public class Tags {
    private Integer id;
    private String tag_name;
    private Integer gid;

    public Tags() {
    }

    public Tags(String tag_name, Integer gid) {
        this.tag_name = tag_name;
        this.gid = gid;
    }
}
