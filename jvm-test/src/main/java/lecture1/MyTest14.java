package lecture1;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 17:24
 **/

public class MyTest14 {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        String resourceName="lecture1/MyTest13.class";
        Enumeration urls=classLoader.getResources(resourceName);
        while (urls.hasMoreElements()){
            URL url= (URL) urls.nextElement();
            System.out.println(url);
        }

    }
}
