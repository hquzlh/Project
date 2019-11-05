package com.ucar.train.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: rbac_work
 * @description: 角色
 * @author: Mr.Zhu
 * @create: 2019-08-20 13:32
 **/
@Data
public class Role  {
    private int rid;
    private String status;
}
