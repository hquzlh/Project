package com.ucar.training.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: final
 * @description: 获取当前时间
 * @author: Mr.Zhu
 * @create: 2019-08-07 09:29
 **/

public class GetDate {
    public  static String getDate(){
    Date date=new Date();
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    return dateFormat.format(date);
    }


}
