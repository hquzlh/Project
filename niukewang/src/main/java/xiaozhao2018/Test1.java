package xiaozhao2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @program: niukewang
 * @description:三个数乘积最大
 * @author: Mr.Zhu
 * @create: 2019-10-09 16:54
 **/

public class Test1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ir);
        int n=Integer.parseInt(br.readLine());
        String[]str=br.readLine().split(" ");
        int[]nums=new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(nums);
        System.out.println(maxValue(nums));
    }
    public static long maxValue(int[]a){
        int length=a.length;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE,
                max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (Integer i:a) {
            if(i>max1){
                max3=max2;
                max2=max1;
                max1=i;
            }else if(i>max2){
                max3=max2;
                max2=i;
            }else if(i>max3){
                max3=i;
            }
            if(i<min1){
                min2=min1;
                min1=i;
            }else if(i<min2){
                min2=i;
            }
        }
        return Math.max((long)max1*max2*max3, (long)max1*min1*min2);
        //return Math.max(a[length-1]*a[length-2]*a[length-3],a[0]*a[1]*a[length-1]);
    }
}
