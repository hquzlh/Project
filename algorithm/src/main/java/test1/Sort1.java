package test1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-27 15:00
 **/

public class Sort1 {
    public static void main(String[] args) {
        String ab="";
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\EDZ\\Desktop\\123.txt"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                ab+=s;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        String [] str=ab.toString().split("，");
        String a=str[0].split("-")[0];
        if(a instanceof String){
            System.out.println(Integer.parseInt(a));
        }
        sort(str);
        /*for (int i = 0; i <str.length ; i++) {
            String b=str[i].split("-")[0];
            System.out.println(str[i].split("-")[0]);

        }*/


    }
    public static String[] sort(String [] datas){

        for (int i = 0; i <datas.length ; i++) {
            boolean tag=true;

            for (int j = 0; j <datas.length-i-1 ; j++) {
                if( datas[j].split("-")[0] instanceof String){
                    System.out.println(datas[j].split("-")[0]);
                    System.out.println(Integer.parseInt(datas[j].split("-")[0]));
                }

                String temp=datas[j];

                int left=Integer.parseInt(datas[j].split("-")[0]);
                int right=Integer.parseInt(datas[j].split("-")[1]);
                int left1=Integer.parseInt(datas[j+1].split("-")[0]);
                int right1=Integer.parseInt(datas[j+1].split("-")[1]);
                if(left>left1){
                    datas[j]=datas[j+1];
                    datas[j+1]=temp;
                    tag=false;
                }else {
                    if(left==left1&&right>right1){

                        datas[j]=datas[j+1];
                        datas[j+1]=temp;
                        tag=false;
                    }
                }
            }
            if(tag=true){
                //return datas;
            }
        }
        return datas;
    }
}
