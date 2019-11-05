package com.ucar.training.bean;

import com.ucar.training.controller.BoardServlet;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

/**
 * @program: final
 * @description: 用户信息
 * @author: Mr.Zhu
 * @create: 2019-08-05 16:47
 **/
@Data
public class User {

    private String uname;
    private String tname;
    private String age;
    private String sex;
    private String pwd;
    private String email;
    private String tel;
    private String[] hobby;
    private String hobbyStr;
    private Boolean isAdmin;
    //private String[] hobby;


}
