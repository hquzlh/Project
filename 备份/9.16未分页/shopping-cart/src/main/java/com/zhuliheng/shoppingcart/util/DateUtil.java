package com.zhuliheng.shoppingcart.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-09 14:41
 **/

public class DateUtil {
    public static String getDate(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }
}
