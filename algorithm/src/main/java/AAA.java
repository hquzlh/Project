import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-17 09:37
 **/

public class AAA {
    public static void main(String[] args) {
        int[]a=new int[]{1,4,5,2,6};
        getLeastNumbers_Solution(a,3);
    }
    public static void m(int[]py){
        int i=py.length;
    }
    public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<input.length;i++){
        list.add(input[i]);
    }
        Collections.sort(list);


        list=new ArrayList<Integer>(list.subList(0, k - 1));

        return list;
}
}

