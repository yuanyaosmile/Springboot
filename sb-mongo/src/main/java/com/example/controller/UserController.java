package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mongo")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    public String getUser(long id){
        User user = userService.getUser(id);
        if (user != null) {
            return user.getUsername();
        }
        return "hello";
    }

    @RequestMapping("/save")
    public String saveUser(User user){
        userService.saveUser(user);
        return "save";
    }

    @RequestMapping("/name")
    public User findByName(String username){
        return userService.findUserByName(username);
    }
}
