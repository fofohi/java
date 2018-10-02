package com.test.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisClusterConfiguration<K,V>{

    @Bean
    public RedisConnectionFactory getRedisConnectionFactory(){
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<K,V> redisTemplateService(RedisConnectionFactory redisConnectionfactory){
        RedisTemplate<K,V> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionfactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
