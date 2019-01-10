package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.example.dao")
public class SbRediesApplication {
    @Autowired
    private RedisConnectionFactory connectionFactory = null;

    @Autowired
    private RedisTemplate redisTemplate = null;

    //自定义初始化
    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }


    public static void main(String[] args) {
        SpringApplication.run(SbRediesApplication.class, args);
    }

}

