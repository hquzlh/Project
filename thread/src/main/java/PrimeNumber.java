/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-09 12:28
 **/

public class PrimeNumber {
    public static void main(String[] args) {
        int temp=0;
        for (int i = 2; i <=100 ; i++) {
            if (judge(i)) {
                temp++;
                if(temp%5==0){
                    System.out.println(i);
                }else {
                    System.out.print(i+"   ");
                }

            }
        }
    }
    public static boolean judge(int i){
        int j=2;

        while (j<i/2){
            if(i%j==0){
                return false;
            }
            j++;
        }
        return true;
    }
}
