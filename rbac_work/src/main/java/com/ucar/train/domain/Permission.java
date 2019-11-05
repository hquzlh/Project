package com.ucar.train.domain;

import lombok.Data;

/**
 * @program: rbac_work
 * @description: 权限
 * @author: Mr.Zhu
 * @create: 2019-08-20 13:32
 **/
@Data
public class Permission {
    private int pid;
    private String permission;
    private String uri;
}
