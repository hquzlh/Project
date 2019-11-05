package zaluan.test5;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-14 11:55
 **/

public class MyList {
    private static List<String> list = new ArrayList<String>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}
