package com.example.service;

import com.example.pojo.User;
import com.example.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    User getUserById(Long id);

    boolean login(HttpServletResponse response, LoginVo loginVo);
}
