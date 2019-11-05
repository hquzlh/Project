package com.hqu.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-04
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-29 17:18
 **/


@Controller
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/query")
    public Map<String,Object> map(){
         List<Map<String,Object>> list=jdbcTemplate.queryForList(" select * from department");
        System.out.println(list.get(0));
         return list.get(0);
    }
}
