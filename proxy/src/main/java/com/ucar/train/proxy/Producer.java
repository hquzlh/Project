package com.ucar.train.proxy;

/**
 * @program: proxy
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-19 09:27
 **/

public class Producer  implements IProducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("拿到钱销售产品"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务并拿到钱"+money);
    }
}
