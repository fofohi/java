package com.demo.test.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {
    //        @Pointcut("@annotation(com.jdd.fm.core.annotations.Action)")
    //    @Pointcut("execution(* com.jdd.tqz.expert.controller.*.*(..))")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.CrossOrigin)")
    public void pointCut() {
    }

    //@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    //public void afterThrowing(JoinPoint pjp, Throwable ex) {
    //    logger.error("[apiController 调用]异常,class:{},method:{},params:{}"
    //            , pjp.getSignature().getDeclaringTypeName()
    //            , pjp.getSignature().getName()
    //            , LogExceptionStackTrace.erroStackTrace(ex));
    //}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object object = pjp.proceed();
        System.out.println(object);
        return object;
    }

}
