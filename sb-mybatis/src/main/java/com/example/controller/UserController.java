package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    public String getUser(long id){
        User user = userService.findUserById(id);
        return user.toString();
    }
}
