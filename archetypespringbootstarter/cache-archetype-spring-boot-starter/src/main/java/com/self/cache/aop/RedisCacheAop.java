package com.self.cache.aop;

import com.self.cache.util.RedisCacheFuncProxy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * log 统一输出
 */
@Aspect
public class RedisCacheAop {

    @Around("execution(* com.self.cache.service.impl..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return RedisCacheFuncProxy.proxyForExecTime(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return null;
        },joinPoint.getSignature());
    }

}
