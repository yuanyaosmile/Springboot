package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 查询用户
     * @param id
     * @return
     */
    User findUserById(long id);
}
