package jianzhi;

/**
 * @program: niukewang
 * @description:旋转数组查找最小
 * @author: Mr.Zhu
 * @create: 2019-10-14 09:23
 **/

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Test3 {
    public int minNumberInRotateArray(int [] array) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        if(array.length==0){
            return 0;
        }
        List<Integer> list = Arrays.stream( array ).boxed().collect(Collectors.toList());
        for(int i=0;i<array.length;i++){
            queue.add(array[i]);
        }
        return queue.peek();


    }
    //还可以使用暴力搜索，集合sort输出第一
}
