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

    public Tags(String tag_name) {
        this.tag_name = tag_name;
    }

    public Tags(Integer id, String tag_name) {
        this.id = id;
        this.tag_name = tag_name;
    }
}
