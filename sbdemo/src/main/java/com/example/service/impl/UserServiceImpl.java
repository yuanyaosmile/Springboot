package com.example.service.impl;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null ) {
            throw new RuntimeException("user is null");
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}
