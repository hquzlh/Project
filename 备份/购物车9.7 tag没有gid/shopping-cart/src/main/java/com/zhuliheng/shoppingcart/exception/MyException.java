package com.zhuliheng.shoppingcart.exception;

import org.springframework.boot.autoconfigure.web.ErrorProperties;

/**
 * @program: shopping-cart
 * @description: 异常测试类
 * @author: Mr.Zhu
 * @create: 2019-09-05 08:52
 **/

public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MyException() {
        super("异常测试成功");

    }

}
