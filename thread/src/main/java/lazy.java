import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-08 08:32
 **/

public class lazy {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
       /* for (Integer integer:list) {
            if(integer.equals(3)){
                list.remove(integer);
            }
        }*/
       /* for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).equals(3)){
                list.remove(i);
            }
        }*/
        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            int data=iterator.next();
            if(data==3){
                iterator.remove();
            }
        }

    }
}
