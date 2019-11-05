package com.zhuliheng.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: shopping-cart
 * @description:异常处理
 * @author: Mr.Zhu
 * @create: 2019-09-05 09:01
 **/
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MyException.class)
    @ResponseBody
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotExistException(MyException ex){
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("message", ex.getMessage());
        System.out.println("自定义异常MyException触发");
        return result;
    }

}
