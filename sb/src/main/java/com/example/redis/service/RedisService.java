package com.example.redis.service;

import com.example.redis.KeyPrefix;

public interface RedisService {

    //获取redis当中的对象
    <T>  T get(KeyPrefix prefix, String key, Class<T> clazz);

    //设置redis中的对象
    <T> boolean set(KeyPrefix prefix, String key, T value);

    //判断key是否存在
    <T> boolean exists(KeyPrefix prefix, String key);

    <T> long increase(KeyPrefix prefix, String key, T value);

    <T> long decrease(KeyPrefix prefix, String key, T value);
}
