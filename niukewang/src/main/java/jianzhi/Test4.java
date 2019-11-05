package jianzhi;

/**
 * @program: niukewang
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-14 09:43
 **/

public class Test4 {
    public static int fabonacci1(int n){
        if(n>1){
            return fabonacci1(n-1)+fabonacci1(n-2);
        }else {
            return n;
        }
    }
    public static  int fabonacci2(int n){
        int temp1=0;
        int temp2=1;
        int date=0;
        if(n==1){
            return 1;
        }
        for (int i = 2; i <=n ; i++) {
            date=temp1+temp2;
            temp1=temp2;
            temp2=date;
        }
        return date;
    }
}
