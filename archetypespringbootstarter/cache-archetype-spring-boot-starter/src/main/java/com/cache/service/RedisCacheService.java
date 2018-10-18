package com.cache.service;

import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.types.Expiration;

import java.util.Map;
import java.util.Set;

public interface RedisCacheService{

    void set(byte[] key, byte[] value);

    byte[] get(byte[] key);

    void set(String key, String value);

    String get(String key);

    boolean set(String key , String value, Expiration expiration, RedisStringCommands.SetOption setOption);

    boolean set(byte[] key,byte[] value, Expiration expiration, RedisStringCommands.SetOption setOption);

    boolean del(String key);

    Long incr(String key);

    Long incrBy(String key, long value);

    boolean exists(String key);

    void hset(byte[] key, byte[] innerKey, byte[] value);

    byte[] hget(byte[] key, byte[] innerKey);

    void hset(String key, String innerKey, String value);

    String hget(String key, String innerKey);

    boolean hdel(String key,String innerKey);

    Map<byte[],byte[]> hgetallRaw(String key);

    Map<String,String> hgetall(String key);

    Long hincr(String key,String innerKey);

    Long hincrBy(String key,String innerKey, long value);

    boolean hexists(String key,String innerKey);

    long ttl(String key);

    String type(String key);

    String spop(String key);

    byte[] spop(byte[] key);

    Long scard(String key);

    void sadd(String key,String... values);

    void sadd(String key,byte[]... values);

    Long srem(String key,String... values);

    Long srem(String key,byte[]... values);

    boolean zadd(String key,String innerKey,double scores);

    Set<ZSetOperations.TypedTuple<String>> zrevrangeWithScores(String key, long begin, long end);

    Set<String> zrevrange(String key , long begin,long end);

    Set<ZSetOperations.TypedTuple<String>> zrangeWithScores(String key,long begin,long end);

    Set<String> zrange(String key,long begin,long end);

    long zcard(String key);

    long zrank(String key,String innerKey);

    long zrevrank(String key,String innerKey);

    long zremove(String key,String... innerKeys);

    double zincrBy(String key, String innerKey,double delta);

    double zincr(String key, String innerKey,double delta);

    long rpush(String key,String value);

    long rpushx(String key,String... values);

    String lpop(String key,String value);

    long lpush(String key,String value);

    long lpushx(String key,String... values);

    String rpop(String key);

    long llenth(String key);

    long lremove(String key,long count ,String value);
}
