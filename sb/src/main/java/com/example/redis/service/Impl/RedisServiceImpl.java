package com.example.redis.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.redis.KeyPrefix;
import com.example.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired(required = false)
    JedisPool jedisPool;

    @Override
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            String realKey = prefix.getPrefix() + key;
            jedis = jedisPool.getResource();
            String string = jedis.get(realKey);
            T t = stringToBean(string, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }

    }

    @Override
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if (str == null || str.length() <= 0)
                return false;

            //生成一个真正的key
            String realkey = prefix.getPrefix() + key;
            int seconds = prefix.expireSeconds();
            if (seconds <= 0) {
                jedis.set(realkey, str);
            }else {
                jedis.setex(realkey, seconds, str);
            }
            return true;
        }finally {
         returnToPool(jedis);
        }
    }

    @Override
    public <T> boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    @Override
    public <T> long increase(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            jedis.incr(realKey);
        }finally {
            returnToPool(jedis);
        }

        return 0;
    }

    @Override
    public <T> long decrease(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            jedis.decr(realKey);
        }finally {
            returnToPool(jedis);
        }

        return 0;
    }

    private <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }

        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return " " + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String string, Class<T> clazz) {
        if (string == null || string.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(string);
        }else if (clazz == String.class) {
            return (T)String.valueOf(string);
        }else if(clazz == long.class || clazz == Long.class){
               return (T)Long.valueOf(string);
        }else {
            return JSON.toJavaObject(JSON.parseObject(string),clazz);
        }

    }


    private void returnToPool(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }
}
