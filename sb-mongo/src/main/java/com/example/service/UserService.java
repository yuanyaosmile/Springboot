package com.example.service;

import com.example.pojo.User;

public interface UserService {
    void saveUser(User user);
    User getUser(long id);
}
