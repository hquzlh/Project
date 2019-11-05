package proxyyy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-19 08:51
 **/

public class StarProxy implements InvocationHandler {
    private Object targer;

    public void setTarger(Object targer) {
        this.targer = targer;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("收钱");
        Object object=method.invoke(targer,args);
        return object;
    }
    public Object creatProxyObj(){
        return Proxy.newProxyInstance(targer.getClass().getClassLoader(),targer.getClass().getInterfaces(),this);
    }
}
