package com.example.controller;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuanyao on 2018/11/9.
 */
@RestController
@RequestMapping("/user")
public class HelloController {
    @Autowired
    User User ;

    @RequestMapping("/index")
    public String index() {
        return "Hello world";
    }
}
