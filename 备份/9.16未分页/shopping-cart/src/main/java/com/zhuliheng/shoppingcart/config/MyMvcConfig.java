package com.zhuliheng.shoppingcart.config;

import com.zhuliheng.shoppingcart.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: shopping-cart
 * @description: mvc相关配置
 * @author: Mr.Zhu
 * @create: 2019-09-02 16:24
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //视图解析
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/cart.html").setViewName("cart");
        registry.addViewController("/deposit.html").setViewName("deposit");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/order.html").setViewName("order");
        registry.addViewController("/insertGoods.html").setViewName("insertGoods");
        registry.addViewController("/exception.html").setViewName("exception");
    }
    //拦截器处理
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/deposit");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/deposit.html");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/insertGoods");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/insertGoods.html");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/order");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/order.html");
    }
    //配置文件虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\IdeaWorkSpace\\shopping-cart\\src\\main\\resources\\static\\upload\\");
    }

}
