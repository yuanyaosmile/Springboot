package com.example.service.impl;

import com.example.pojo.User;
import com.example.service.UserBatchService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Barry
 * @date 2019/1/9
 */
@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    UserService userService;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        int count = 0;
        for(User user : userList){
            count += userService.insertUser(user);
        }
        return count;
    }
}
