package com.example.service;

import com.example.pojo.User;

/**
 * @Author Barry
 * @date 2019/1/9
 */
public interface UserService {
    User findUserById(long id);

    int insertUser(User user);
}
