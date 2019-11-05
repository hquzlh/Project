package com.ucar.train.domain;

import lombok.Data;

/**
 * @program: rbac_work
 * @description: 角色权限对应关系
 * @author: Mr.Zhu
 * @create: 2019-08-20 16:00
 **/
@Data
public class RolePermission {
    private int rpid;
    private int rid;
    private int pid;
}
