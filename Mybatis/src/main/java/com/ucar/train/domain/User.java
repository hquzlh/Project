package com.ucar.train.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: Mybatis
 * @description: 用户类
 * @author: Mr.Zhu
 * @create: 2019-08-12 16:03
 **/
@Data
public class User implements Serializable {
    private int id;
    private  String username;
    private Date birthday;
    private String sex;
    private String address;
}
