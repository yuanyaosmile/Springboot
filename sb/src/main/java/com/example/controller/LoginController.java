package com.example.controller;

import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.redis.service.RedisService;
import com.example.result.CodeMsg;
import com.example.result.Result;
import com.example.service.SKUserService;
import com.example.service.UserService;
import com.example.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequestMapping("/login")
@Controller
@Slf4j
public class LoginController {

    @Autowired
    SKUserService skUserService;
    @Autowired
    RedisService redisService;

    @Autowired
    UserDao userDao;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "Login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        //登录
       /* String passInput = loginVo.getMobile();
        String mobile = loginVo.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if (StringUtils.isEmpty(passInput)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }*/

        skUserService.login(response, loginVo);

        /*if (cm.getCode() == 20000) {
            return Result.success(true);
        }else{
            return Result.error(cm);
        }*/
        return Result.success(true);
    }
}
