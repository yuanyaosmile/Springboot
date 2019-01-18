package com.example.config;

import com.example.dao.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Barry
 * @date 2019/1/8
 */
//@Configuration
public class MyBatisConfig {

    @Autowired
    SqlSessionFactory sqlSessionFactory = null;

    @Bean("userMapper")
    public MapperFactoryBean<UserMapper> initUserMapper(){
        MapperFactoryBean<UserMapper> userMapperMapperFactoryBean = new MapperFactoryBean<>();
        userMapperMapperFactoryBean.setMapperInterface(UserMapper.class);
        userMapperMapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
        return userMapperMapperFactoryBean;
    }
}
