package com.cache.service;

public interface RedisCacheService{

    void set(byte[] key,byte[] value);

    byte[] get(byte[] key);

    void set(String key,String value);

    String get(String key);




}
