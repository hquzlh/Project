package com.ucar.train.domain;

import lombok.Data;

/**
 * @program: rbac_work
 * @description: 用户角色对应关系
 * @author: Mr.Zhu
 * @create: 2019-08-20 15:59
 **/
@Data
public class UserRole {
    private int urid;
    private int uid;
    private int rid;
}
