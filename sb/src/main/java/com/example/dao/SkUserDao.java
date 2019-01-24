package com.example.dao;

import com.example.pojo.SkUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SkUserDao {

    @Select("select * from user where id = #{id}")
    SkUser getUserById(@Param("id") long id);
}
