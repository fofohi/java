package com.self.cache.config;

import com.self.cache.aop.RedisCacheAop;
import com.self.cache.service.RedisCacheService;
import com.self.cache.service.impl.RedisCacheServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ConditionalOnClass(RedisTemplate.class)
public class RedisAutoConfiguration {


    /**
     * 存放byte数组的的template在需要存放proto buf 对象的时候使用
     * @param redisConnectionFactory
     * @return
     */
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

    /**
     * 项目内实际用的服务
     * @return
     */
    @ConditionalOnMissingBean
    @Bean
    public RedisCacheService redisCacheService(){
        return new RedisCacheServiceImpl();
    }

    /**
     * 切面
     * @return
     */
    @Bean
    public RedisCacheAop getRedisCacheAop(){
        return new RedisCacheAop();
    }
}
