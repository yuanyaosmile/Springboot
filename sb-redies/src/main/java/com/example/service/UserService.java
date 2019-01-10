package com.example.service;

import com.example.pojo.User;

import java.util.List;

/**
 * @Author Barry
 * @date 2019/1/10
 */
public interface UserService {
    User getUser(Long id);

    User insertUser(User user);

    User updateUserName(Long id, String userName);

    List<User> findUsers(String username, String note);

    int deleteUser(Long id);
}
