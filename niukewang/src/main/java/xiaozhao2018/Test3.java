package xiaozhao2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: niukewang
 * @description:获取最大回文串
 * @author: Mr.Zhu
 * @create: 2019-10-11 13:36
 **/

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String date=br.readLine();
        System.out.println(getLongHuiWen(date));
    }
    public static String getLongHuiWen(String date){
        int max=0;
        String maxString=null;
        int length=date.length();
        for (int i = 0; i <length ; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (isHuiWen(date.substring(i, j), j - i)) {
                    if (j - i > max) {
                        max = j - i;
                        maxString = date.substring(i, j);
                    }
                }
            }
        }
        return maxString;
    }

    public static boolean isHuiWen(String a,int n){
        int k=n/2;
        for (int i = 0; i <k ; i++) {
            if(a.charAt(i)!=a.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
