package com.zhuliheng.shoppingcart.controller;

import com.zhuliheng.shoppingcart.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shopping-cart
 * @description: ExeController
 * @author: Mr.Zhu
 * @create: 2019-09-05 09:27
 **/
@RestController
public class ExceptionController {
    @RequestMapping("/throw")
    public String throwException(){
        throw new MyException();

    }
}
