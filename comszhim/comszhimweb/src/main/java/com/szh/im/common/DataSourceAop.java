package com.szh.im.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * Created by alongsea2 on 2017/4/11.
 */
@Component
@Aspect
public class DataSourceAop {
    public static String t;

    @Around("execution(* com.szh.im.controller.*.*(..))")
    public Object businessService(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("============>");
        DataSourceAop.t = "readDataSource1";
        Object retVal = pjp.proceed();
        //如果有特定注解,获取应该使用的库
        //模拟
        System.out.println("<============");
        return retVal;
    }
}
