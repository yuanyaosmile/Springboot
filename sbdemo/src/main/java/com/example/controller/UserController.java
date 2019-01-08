package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
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
     private UserService userService = null;

    @RequestMapping("/print")
    public String printUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.printUser(user);
        return "success";
    }
}
