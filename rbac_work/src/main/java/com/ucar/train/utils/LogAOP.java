
package com.ucar.train.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;




/**
 * @program: rbac_work
 * @description: 记录接口调用信息
 * @author: Mr.Zhu
 * @create: 2019-08-27 15:49
 **/

@Component
@Aspect
public class LogAOP {
    @Pointcut("execution(* com.ucar.train.service.*.*(..))")
    public void InterfacePointCut(){
    }
    @Around("InterfacePointCut()")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable{
        Object obj=null;
        long begin=System.currentTimeMillis();
        obj=pjp.proceed();
        long end=System.currentTimeMillis();
        System.out.print("调用了"+pjp.getTarget().getClass().getName()+"的");
        //简单输出不采用日志
        System.out.println(pjp.getSignature().getName()+"方法，执行时间"+(end-begin)+"ms");
        System.out.println("------------------------------------------------------");
        return obj;
    }
}
