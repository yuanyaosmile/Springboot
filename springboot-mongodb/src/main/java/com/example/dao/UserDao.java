package com.example.dao;

import com.example.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    void saveUser(User user);

    User getUser(Long id);
}
