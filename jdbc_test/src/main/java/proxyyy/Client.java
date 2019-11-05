package proxyyy;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-19 08:54
 **/

public class Client {
    public static void main(String[] args) {
        Star ldh=new LiuHuan();
        StarProxy proxy=new StarProxy();
        proxy.setTarger(ldh);
        Star star= (Star) proxy.creatProxyObj();
        star.sing("sss");
        star.dance("ssss");
    }
}
