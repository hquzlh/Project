package com.ucar.train.cglib;

import com.ucar.train.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
       final Producer producer=new Producer();
        Producer cglibProducer =(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(8000f);
        cglibProducer.afterService(10000f);
    }
}
