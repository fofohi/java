package com.szh.im.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by alongsea2 on 2017/4/11.
 */
@Aspect
public class DataSourceAop {

    @Around("execution(* com.szh.im.controller.*.*(..))")
    public Object businessService(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("============>");
        Object retVal = pjp.proceed();
        System.out.println("<============");
        return retVal;
    }
}
