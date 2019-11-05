package com.ucar.train.domain;

import lombok.Data;

/**
 * @program: rbac_work
 * @description: 用户类
 * @author: Mr.Zhu
 * @create: 2019-08-20 09:26
 **/
@Data
public class User {
    private int uid;
    private String uname;
    private String password;
}
