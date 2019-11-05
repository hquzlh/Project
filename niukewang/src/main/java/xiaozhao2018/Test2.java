package xiaozhao2018;


import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @program: niukewang
 * @description:输入日期判断星期几
 * @author: Mr.Zhu
 * @create: 2019-10-11 10:53
 **/

public class Test2 {
    public static void main(String[] args) throws ParseException, IOException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar=Calendar.getInstance();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String  data=null;
        if((data=br.readLine())!=null){

            calendar.setTime(sdf.parse(data));
        }
        int i=calendar.get(Calendar.DAY_OF_WEEK);
        if(i==1){
            System.out.println("今天是星期日");
        }else {
            System.out.println("今天是星期"+(i-1));
        }

    }


}
