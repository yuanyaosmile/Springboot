package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.result.CodeMsg;
import com.example.service.UserService;
import com.example.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean login(HttpServletResponse response, LoginVo loginVo) {


        return false;
    }
}
