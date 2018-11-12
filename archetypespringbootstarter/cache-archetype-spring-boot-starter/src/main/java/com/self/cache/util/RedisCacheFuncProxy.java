package com.self.cache.util;

import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * 统一log 实现
 */
public class RedisCacheFuncProxy {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheFuncProxy.class);

    public static Object proxyForExecTime(Supplier<Object> supplier, Signature signature){
        try {
            long begin = System.currentTimeMillis();
            Object data = supplier.get();
            long execTime = System.currentTimeMillis() - begin;
            if(execTime > 500){
                logger.warn("redis command {} exec time is {} which is over 0.5s",signature != null ? signature.getName() : "no func name",execTime);
            }else{
                logger.info("redis command {} exec time is {}",signature != null ? signature.getName() : "no func name",execTime);
            }
            return data;
        }catch (Exception e){
            logger.error("proxyForExecTime error",e);
            return null;
        }
    }
}
