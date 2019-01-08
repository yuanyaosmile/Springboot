package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper = null;

    @Override
    public User findUserById(long id) {
        return userMapper.findUserById(id);
    }
}
