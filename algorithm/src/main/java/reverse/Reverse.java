package reverse;

import java.util.Collections;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 16:55
 **/

public class Reverse {
    public static void main(String[] args) {
        String str="abcdefghijklmn";
        String str1=reverse2(str);
        //reverse1(str);
        System.out.println(str1);
        reverse3(str);

    }
    //StringBuffer或StringBuilder的reverse反转
    public static void reverse1(String str){
        String afterReverse=new StringBuilder(str).reverse().toString();
        System.out.println(afterReverse);
    }
    //String递归二分法
    public static String reverse2(String str){
        int length=str.length();
        if(length<=1){

            return str;
        }
        String left=str.substring(0,length/2);
        String right=str.substring(length/2,length);
        String afterReverse=reverse2(right)+reverse2(left);
        return afterReverse;
    }
    //char数组拼接
    public static void reverse3(String str){
        char[]chars=str.toCharArray();
        String reverse="";
        for (int i = chars.length-1; i >=0 ; i--) {
            reverse+=chars[i];
        }
        System.out.println(reverse);
    }
}
