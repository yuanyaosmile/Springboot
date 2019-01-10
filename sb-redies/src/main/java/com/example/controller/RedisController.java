package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Barry
 * @date 2019/1/9
 */
@RestController
@RequestMapping("/redis")
@EnableCaching
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("/stringAndHash")
    public Map<String, Object> testStringAndHash(){
        redisTemplate.opsForValue().set("key1","value");
        //注意：这里使用了JDK的序列化器，所以Redis保存时不是整数，不能运算
        redisTemplate.opsForValue().set("int_key","1");
        stringRedisTemplate.opsForValue().set("int", "1");
        //使用运算
        stringRedisTemplate.opsForValue().increment("int", 1);
        //获取底层Jedis连接
        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        //减一操作，这个命令RedisTemplate不支持，所以先获取底层连接再操作
        jedis.decr("int");
        Map<String, String> hash = new HashMap<>(8);
        hash.put("field1","value1");
        hash.put("field2","value2");
        //存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash",hash);
        //新增一个字段
        stringRedisTemplate.opsForHash().put("hash","field2","value3");
        //绑定散列操作的key，这样可以连续对同一个散列数据类型进行操作
        BoundHashOperations hashOperations = stringRedisTemplate.boundHashOps("hash");
        //删除两个字段，新增一个字段
        hashOperations.delete("field1","field2");
        hashOperations.put("field4","value5");
        Map<String, Object> map = new HashMap<String, Object>(8);
        map.put("success",true);
        return map;
    }

    @RequestMapping("/list")
    public Map<String, Object> testList(){
        //插入两个链表，注意他们在链表的顺序
        //链表从左到右的顺序为v10，v8，v6，v4，v2
        stringRedisTemplate.opsForList().leftPushAll("list1","v2", "v4", "v6", "v8", "v10");
        //链表从左到右的顺序为v1，v2，v3，v4，v5，v6
        stringRedisTemplate.opsForList().rightPushAll("list2","v1", "v2", "v3", "v4", "v5", "v6");
        //绑定list2的链表操作
        BoundListOperations boundListOperations = stringRedisTemplate.boundListOps("list2");
        //从右边弹出一个成员
        Object result1 = boundListOperations.rightPop();
        //获取定为元素，Redis从0开始计算，这里的值为V2
        Object result2 = boundListOperations.index(1);
        //从左边插入链表
        boundListOperations.leftPush("v0");
        //求链表长度
        Long size = boundListOperations.size();
        //求链表下标区间成员，整个链表下标范围为0到size-1，这里不取最后一个元素
        List elements = boundListOperations.range(0,size-2);
        Map<String, Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }
}
