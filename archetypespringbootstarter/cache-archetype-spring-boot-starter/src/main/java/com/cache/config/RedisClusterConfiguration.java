package com.cache.config;

import com.cache.service.RedisCacheService;
import com.cache.service.impl.RedisCacheServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisClusterConfiguration{

    @ConditionalOnMissingBean
    @Bean
    public RedisCacheService redisCacheService(){
        return new RedisCacheServiceImpl();
    }

    @ConditionalOnMissingBean(name = "redisClusterByteTemplate")
    @Bean
    @Qualifier(value = "redisClusterByteTemplate")
    public RedisTemplate<String,Byte[]> redisClusterByteTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setEnableDefaultSerializer(false);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }



}
