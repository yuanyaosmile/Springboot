package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Barry
 * @date 2019/1/10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper  userMapper;

    /**
     * 获取id，取参数id缓存用户
     * @param id
     * @return
     */
    @Override
    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_user' + #id")
    public User getUser(Long id) {
        return null;
    }

    /**
     * 插入新用户，最后mybatis会回填id，取结果id缓存用户
     * @param user
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_user' + #result.id")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    /**
     * 更新数据后，更新缓存，如果conditional配置项使结果返回为null，不缓存
     * @param id
     * @param userName
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisCache", condition = "#result != 'null'", key = "'redis_user' + #id")
    public User updateUserName(Long id, String userName) {
        //此处调用getUser方法，改方法缓存注解失效，所以这里还是会执行sql，将查询到数据库最新数据
        User user = this.getUser(id);
        if (user == null) {
            return null;
        }
       user.setUsername(userName);
        userMapper.updateUser(user);
        return user;
    }

    /**
     * 命中率低，不采用缓存机制
     * @param username
     * @param note
     * @return
     */
    @Override
    @Transactional
    public List<User> findUsers(String username, String note) {
        return userMapper.findUsers(username,note);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = "redisCache", key = "'redis_user' + #id", beforeInvocation = false)
    public int deleteUser(Long id) {
        return userMapper.deleteUser(id);
    }
}
