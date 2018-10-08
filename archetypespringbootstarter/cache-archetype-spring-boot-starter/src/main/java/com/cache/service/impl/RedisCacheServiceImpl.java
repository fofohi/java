package com.cache.service.impl;

import com.cache.service.RedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.function.Supplier;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class);

    @Autowired
    @Qualifier(value = "redisClusterByteTemplate")
    private RedisTemplate<String,byte[]> redisClusterByteTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private String getWrapKey(String key) {
        return key;
    }

    private String getWrapKey(byte[] key) {
        try {
            return new String(key,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object proxyForExecTime(Supplier<Object> supplier){
        long begin = System.currentTimeMillis();
        try {
            Object data = supplier.get();
            logger.info("exec time is {}",System.currentTimeMillis() - begin);
            return data;
        }catch (Exception e){
            logger.error("exec error {}",supplier.toString());
            return null;
        }
    }

    @Override
    public void set(byte[] key, byte[] value) {
        proxyForExecTime(()-> {
            this.redisClusterByteTemplate.opsForValue().set(getWrapKey(key),value);
            return null;
        });
    }

    @Override
    public byte[] get(byte[] key) {
        return (byte[]) proxyForExecTime(() -> this.redisClusterByteTemplate.opsForValue().get(this.getWrapKey(key)));
    }

    @Override
    public void set(String key, String value) {
        proxyForExecTime(()-> {
            this.redisTemplate.opsForValue().set(getWrapKey(key),value);
            return null;
        });
    }

    @Override
    public String get(String key) {
        return (String) proxyForExecTime(() -> this.redisTemplate.opsForValue().get(getWrapKey(key)));
    }
}
