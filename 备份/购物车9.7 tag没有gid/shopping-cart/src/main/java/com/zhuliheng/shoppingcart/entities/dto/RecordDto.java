package com.zhuliheng.shoppingcart.entities.dto;

import lombok.Data;

/**
 * @program: shopping-cart
 * @description: 用户操作记录
 * @author: Mr.Zhu
 * @create: 2019-09-04 15:02
 **/
@Data
public class RecordDto {
    private String name;
    private String date;
    private String operation;

    public RecordDto() {
    }

    public RecordDto(String name, String date,String operation) {
        this.name = name;
        this.date = date;
        this.operation=operation;
    }
}
