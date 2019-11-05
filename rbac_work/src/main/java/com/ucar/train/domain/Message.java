package com.ucar.train.domain;

import lombok.Data;

import java.util.Date;

/**
 * @program: rbac_work
 * @description: 留言
 * @author: Mr.Zhu
 * @create: 2019-08-20 13:32
 **/
@Data
public class Message {
    private Integer bid;
    private  String name;
    private String message;
    private Date date;
}
