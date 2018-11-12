package com.self.cache.service.impl;

import com.self.cache.service.RedisCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class);

    @Autowired
    @Qualifier(value = "redisClusterByteTemplate")
    private RedisTemplate<String,byte[]> redisClusterByteTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 统一转换key
     * @param key string
     * @return
     */
    private String getWrapKey(String key) {
        return key;
    }

    /**
     * 统一转换key
     * @param key string
     * @return
     */
    private String getWrapKey(byte[] key){
        try {
            return new String(key,"utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("getWrapKey error",e);
        }
        return null;
    }


    @Override
    public void set(byte[] key, byte[] value) {
        this.redisClusterByteTemplate.opsForValue().set(getWrapKey(key),value);
    }

    @Override
    public byte[] get(byte[] key) {
        return this.redisClusterByteTemplate.opsForValue().get(getWrapKey(key));
    }

    @Override
    public void set(String key, String value) {
        this.redisTemplate.opsForValue().set(getWrapKey(key),value);
    }

    @Override
    public String get(String key) {
        return this.redisTemplate.opsForValue().get(getWrapKey(key));
    }

    /**
     * @param key
     * @param value
     * @param expiration
     * @param setOption
     * @return true set success otherwise fail
     */
    @Override
    public boolean set(String key, String value, Expiration expiration, RedisStringCommands.SetOption setOption) {
        Boolean isPut = this.redisTemplate.execute((RedisCallback<Boolean>)
                connection -> connection.set(key.getBytes(), value.getBytes(), expiration, setOption));
        return isPut != null ? isPut : false;
    }

    /**
     * @param key
     * @param value
     * @param expiration
     * @param setOption
     * @return true set success otherwise fail
     */
    @Override
    public boolean set(byte[] key, byte[] value, Expiration expiration, RedisStringCommands.SetOption setOption) {
        Boolean isPut = this.redisClusterByteTemplate.execute((RedisCallback<Boolean>)
                connection -> connection.set(key, value, expiration, setOption));
        return isPut != null ? isPut : false;
    }

    @Override
    public boolean del(String key) {
        Boolean isSuccess = this.redisTemplate.delete(getWrapKey(key));
        return isSuccess == null ? false : isSuccess;
    }

    @Override
    public Long incr(String key) {
        return this.incrBy(getWrapKey(key),1L);
    }

    @Override
    public Long incrBy(String key, long value) {
        return this.redisTemplate.opsForValue().increment(getWrapKey(key),value);
    }

    @Override
    public boolean exists(String key) {
        Boolean isExists = this.redisClusterByteTemplate.execute((RedisCallback<Boolean>) connection -> connection.exists(key.getBytes()));
        return isExists == null ? false : isExists;
    }

    @Override
    public void hset(byte[] key, byte[] innerKey, byte[] value) {
        this.redisClusterByteTemplate.opsForHash().put(getWrapKey(key),innerKey,value);
    }

    @Override
    public byte[] hget(byte[] key, byte[] innerKey) {
        return (byte[]) this.redisClusterByteTemplate.opsForHash().get(getWrapKey(key),innerKey);
    }

    @Override
    public void hset(String key, String innerKey, String value) {
        this.redisTemplate.opsForHash().put(getWrapKey(key),innerKey,value);
    }

    @Override
    public String hget(String key, String innerKey) {
        return (String) this.redisTemplate.opsForHash().get(getWrapKey(key),innerKey);
    }

    @Override
    public boolean hdel(String key, String innerKey) {
        long isDel = this.redisTemplate.opsForHash().delete(getWrapKey(key),innerKey);
        return isDel != 0;
    }

    /**
     * 获取原始数据的map
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<byte[], byte[]> hgetallRaw(String key) {
        return this.redisClusterByteTemplate.execute((RedisCallback<Map<byte[], byte[]>>)
                connection -> connection.hGetAll(getWrapKey(key).getBytes()));
    }

    @Override
    public Map<String, String> hgetall(String key) {
        Map<byte[], byte[]> rawMap = hgetallRaw(key);
        Map<String,String> map = new HashMap<>();
        if(rawMap != null && rawMap.size() > 0){
            for (Map.Entry<byte[], byte[]> entry : rawMap.entrySet()) {
                map.put(getWrapKey(entry.getKey()), getWrapKey(entry.getValue()));
            }
        }
        return map;
    }

    @Override
    public Long hincr(String key,String innerKey) {
        return this.hincrBy(getWrapKey(key),innerKey,1L);
    }

    @Override
    public Long hincrBy(String key, String innerKey,long value) {
        return this.redisTemplate.opsForHash().increment(getWrapKey(key),innerKey,value);
    }

    @Override
    public boolean hexists(String key,String innerKey) {
        Boolean isExists = this.redisClusterByteTemplate.execute((RedisCallback<Boolean>) connection -> connection.hExists(key.getBytes(),innerKey.getBytes()));
        return isExists == null ? false : isExists;
    }

    @Override
    public long ttl(String key) {
        Long times = this.redisClusterByteTemplate.execute((RedisCallback<Long>) connection -> connection.ttl(key.getBytes()));
        return times == null ? 0 : times;
    }

    @Override
    public String type(String key) {
        return this.redisTemplate.type(key).name();
    }

    @Override
    public String spop(String key) {
        return this.redisTemplate.execute((RedisCallback<String>) connection -> {
            byte[] result = connection.sPop(key.getBytes());
            if(result != null && result.length > 0){
                return getWrapKey(result);
            }
            return null;
        });
    }

    @Override
    public byte[] spop(byte[] key) {
        return this.redisClusterByteTemplate.execute((RedisCallback<byte[]>) connection -> connection.sPop(key));
    }

    @Override
    public Long scard(String key) {
        return this.redisTemplate.opsForSet().size(key);
    }

    @Override
    public void sadd(String key, String... values) {
        for (String value : values) {
            sadd(key, value.getBytes());
        }
    }

    @Override
    public void sadd(String key, byte[]... values) {
        for (byte[] value : values) {
            this.redisClusterByteTemplate.opsForSet().add(getWrapKey(key), value);
        }
    }

    @Override
    public Long srem(String key, String... values) {
        return this.redisTemplate.opsForSet().remove(getWrapKey(key), values);
    }

    @Override
    public Long srem(String key, byte[]... values) {
        return this.redisClusterByteTemplate.opsForSet().remove(getWrapKey(key),values);
    }

    @Override
    public boolean zadd(String key,String innerKey,double scores) {
        Boolean isSuccess = this.redisTemplate.opsForZSet().add(getWrapKey(key), innerKey, scores);
        return isSuccess == null ? false : isSuccess;
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> zrevrangeWithScores(String key, long begin, long end) {
        return this.redisTemplate.opsForZSet().reverseRangeWithScores(getWrapKey(key),begin,end);
    }

    @Override
    public Set<String> zrevrange(String key, long begin, long end) {
        return this.redisTemplate.opsForZSet().reverseRange(getWrapKey(key),begin,end);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> zrangeWithScores(String key, long begin, long end) {
        return this.redisTemplate.opsForZSet().rangeWithScores(getWrapKey(key),begin,end);
    }

    @Override
    public Set<String> zrange(String key, long begin, long end) {
        return this.redisTemplate.opsForZSet().range(getWrapKey(key),begin,end);
    }

    @Override
    public long zcard(String key) {
        Long result = this.redisTemplate.opsForZSet().zCard(getWrapKey(key));
        return result == null ? 0 : result;
    }

    @Override
    public long zrank(String key, String innerKey) {
        Long result = this.redisTemplate.opsForZSet().rank(getWrapKey(key),innerKey);
        return result == null ? -1 : result;
    }

    @Override
    public long zrevrank(String key, String innerKey) {
        Long result = this.redisTemplate.opsForZSet().reverseRank(getWrapKey(key),innerKey);
        return result == null ? -1 : result;
    }

    @Override
    public long zremove(String key, String... innerKeys) {
        Long result = this.redisTemplate.opsForZSet().remove(getWrapKey(key), innerKeys);
        return result == null ? 0 : result;
    }

    @Override
    public double zincrBy(String key, String innerKey,double delta) {
        Double result = this.redisTemplate.opsForZSet().incrementScore(getWrapKey(key), innerKey, delta);
        return result == null ? 0 : result;
    }

    @Override
    public double zincr(String key, String innerKey, double delta) {
        return this.zincrBy(getWrapKey(key),innerKey,1d);
    }

    @Override
    public long rpush(String key, String value) {
        return this.rpushx(getWrapKey(key),value);
    }

    @Override
    public long rpushx(String key, String... values) {
        Long result = this.redisTemplate.opsForList().rightPushAll(getWrapKey(key), values);
        return result == null ? 0 : result;
    }

    @Override
    public String lpop(String key, String value) {
        return this.redisTemplate.opsForList().leftPop(getWrapKey(key));
    }

    @Override
    public long lpush(String key, String value) {
        return this.lpushx(getWrapKey(key),value);
    }

    @Override
    public long lpushx(String key, String... values) {
        Long result = this.redisTemplate.opsForList().leftPushAll(key,values);
        return result == null ? 0 : result;
    }

    @Override
    public String rpop(String key) {
        return this.redisTemplate.opsForList().rightPop(getWrapKey(key));
    }

    @Override
    public long llenth(String key) {
        Long result = this.redisTemplate.opsForList().size(getWrapKey(key));
        return result == null ? 0 : result;
    }

    @Override
    public long lremove(String key, long count, String value) {
        Long result = this.redisTemplate.opsForList().remove(getWrapKey(key),count,value);
        return result == null ? 0 : result;
    }
}
