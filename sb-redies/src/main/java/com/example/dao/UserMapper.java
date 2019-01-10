package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Barry
 * @date 2019/1/10
 */
@Repository
public interface UserMapper {

    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName")String userName,@Param("note") String note);

    int deleteUser(Long id);
}
