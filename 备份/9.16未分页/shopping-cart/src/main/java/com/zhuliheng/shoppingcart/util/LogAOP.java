
package com.zhuliheng.shoppingcart.util;


import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.RecordDto;
import com.zhuliheng.shoppingcart.mapper.UserMapper;
import com.zhuliheng.shoppingcart.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: rbac_work
 * @description: 记录接口调用信息
 * @author: Mr.Zhu
 * @create: 2019-08-27 15:49
 **/
@Aspect
@Component
public class LogAOP {

    @Autowired
    UserMapper userMapper;
    @Pointcut("execution(* com.zhuliheng.shoppingcart.controller.UserController.login(..))")
    public void PointCut(){
    }
    @Around("PointCut()")
    public Object logTime(ProceedingJoinPoint pjp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String date = dateFormat.format(new Date());
        User users= (User) pjp.getArgs()[0];
        Object obj=null;
        try {
            obj=pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        String tag=(obj=="redirect:/main.html")?"登陆成功":"登陆失败";
        userMapper.record(new RecordDto(users.getName(),date,tag));
        return obj;

    }
}
