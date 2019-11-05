import java.util.Arrays;

/**
 * @program: allTest
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-10 10:09
 **/

public class Test1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum=0L;
        for (long i = 0; i <Integer.MAX_VALUE ; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
