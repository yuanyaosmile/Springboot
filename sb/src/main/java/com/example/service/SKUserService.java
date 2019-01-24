package com.example.service;

import com.example.pojo.SkUser;
import com.example.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

public interface SKUserService {

    SkUser getById(long id);

    boolean login(HttpServletResponse response, LoginVo loginVO);

    SkUser getByToken(HttpServletResponse response, String token);
}
