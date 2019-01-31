package com.example.service.impl;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user, "user");
    }

    @Override
    public User getUser(long id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        //return mongoTemplate.findById(id,User.class);
        return mongoTemplate.findOne(query, User.class);
    }
}
