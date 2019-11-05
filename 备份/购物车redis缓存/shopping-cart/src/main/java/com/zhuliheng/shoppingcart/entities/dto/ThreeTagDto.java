package com.zhuliheng.shoppingcart.entities.dto;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description: 标签的父子类
 * @author: Mr.Zhu
 * @create: 2019-09-05 17:00
 **/
@Data
public class ThreeTagDto {
    private Integer id;
    private Integer f_id;
    private Integer s_id;
    private Integer gid;
    private Integer t_id;

    public ThreeTagDto() {
    }

    public ThreeTagDto(Integer f_id, Integer s_id, Integer gid, Integer t_id) {
        this.f_id = f_id;
        this.s_id = s_id;
        this.gid = gid;
        this.t_id = t_id;
    }


}
