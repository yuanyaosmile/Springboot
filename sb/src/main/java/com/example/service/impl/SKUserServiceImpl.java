package com.example.service.impl;

import com.example.dao.SkUserDao;
import com.example.exception.GlobalException;
import com.example.pojo.SkUser;
import com.example.redis.SKUserKey;
import com.example.redis.service.RedisService;
import com.example.result.CodeMsg;
import com.example.service.SKUserService;
import com.example.utils.MD5Util;
import com.example.utils.UUIDUtil;
import com.example.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class SKUserServiceImpl implements SKUserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    SkUserDao skUserDao;

    @Autowired
    RedisService redisService;

    @Override
    public SkUser getById(long id) {

        return skUserDao.getUserById(id);
    }

    @Override
    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();

        if (StringUtils.isEmpty(formPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_EMPTY);
        }
        //check whether the mobile exists;
        SkUser skuser = skUserDao.getUserById(Long.parseLong(mobile));
        if (skuser == null) {
            throw new GlobalException(CodeMsg.MOBILE_EMPTY);
        }

        String dbPass = skuser.getPassword();
        String dbSalt = skuser.getSalt();
        String calPass = MD5Util.formPassTodbPass(formPass, dbSalt);
        if (!dbPass.equals(calPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

        String token = UUIDUtil.uuid();
        addCookie(response, token, skuser);

        return true;
    }

    @Override
    public SkUser getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        SkUser user = redisService.get(SKUserKey.token, token, SkUser.class);
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

    private void addCookie(HttpServletResponse response, String token, SkUser skuser) {
        redisService.set(SKUserKey.token, token, skuser);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(SKUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
