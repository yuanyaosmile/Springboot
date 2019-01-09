package com.example.service;

import com.example.pojo.User;

import java.util.List;

/**
 * @Author Barry
 * @date 2019/1/9
 */
public interface UserBatchService {
    int insertUsers(List<User> userList);
}
