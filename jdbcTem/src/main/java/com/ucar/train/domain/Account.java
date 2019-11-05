package com.ucar.train.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: jdbcTem
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-19 13:25
 **/
@Data
public class Account  implements Serializable {
    private int id;
    private String name;
    private Float money;

}
