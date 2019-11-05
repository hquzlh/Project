package com.ucar.train.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: proxy
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-19 09:31
 **/

public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        producer.saleProduct(10000f);
        IProducer proxyProducer=(IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                Float money = (Float) args[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        proxyProducer.saleProduct(10000f);
        proxyProducer.afterService(10000f);
    }
}
