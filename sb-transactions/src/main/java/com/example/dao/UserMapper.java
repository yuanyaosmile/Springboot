package com.example.dao;

import com.example.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author Barry
 * @date 2019/1/9
 */
@Repository
public interface UserMapper {
    User findUserById(long id);

    int  insertUser(User user);
}
