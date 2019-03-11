package com.example.service.impl;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    // 注入MongoTemplate对象
    @Autowired
    private MongoTemplate mongoTmpl ;

    @Override
    public void saveUser(User user) {
        mongoTmpl.save(user, "user");
    }

    @Override
    public User getUser(Long id) {
        return mongoTmpl.findById(id,User.class);
    }
}
