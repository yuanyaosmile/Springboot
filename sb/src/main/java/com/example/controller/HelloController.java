package com.example.controller;

import com.example.pojo.User;
import com.example.redis.UserKey;
import com.example.redis.service.RedisService;
import com.example.result.Result;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/get")
    public Result get(){
        return Result.success("success");
    }

    @RequestMapping("/t")
    public String gett(Model model){
        model.addAttribute("name","barry");
        return "hello";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Result<User> getUser(long id ){
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> getLong(){
        User user = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }

    @ResponseBody
    @RequestMapping("/redis/set")
    public Result<Boolean> redisSet(){
        User user = new User();
        user.setId(1);
        user.setUsername("barry");
        redisService.set(UserKey.getById, "" + 1, user);
        redisService.get(UserKey.getById, "" + 1, User.class);
        return Result.success(true);

    }
}
