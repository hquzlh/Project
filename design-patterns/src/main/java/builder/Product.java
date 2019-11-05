package builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 17:18
 **/

public class Product {
    List<String> parts=new ArrayList<String>();
    public  void  add(String part){
        parts.add(part);
    }
    public void show(){
        System.out.println("------产品创建-----");
        for (String part:parts) {
            System.out.println(part);
        }
    }
}
