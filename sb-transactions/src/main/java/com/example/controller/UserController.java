package com.example.controller;

import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.service.UserBatchService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Barry
 * @date 2019/1/9
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBatchService userBatchService;

    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public String findUserById(long id){
        User user = userService.findUserById(id);
        System.out.println(user.getUsername());
        return "hello world";
    }

    @RequestMapping("/insert")
    public Map<String ,Object> insert(String username, String note){
        User user =  new User();
        user.setUsername(username);
        user.setNote(note);

        int update = userService.insertUser(user);
        Map<String,Object> result = new HashMap<>(16);
        result.put("success",update == 1);
        result.put("user",user);
        return result;
    }

    @RequestMapping("/insertUsers")
    public Map<String,Object> insertUsers(String username1, String note1, String username2, String  note2 ){
        User user1 = new User();
        user1.setUsername(username1);
        user1.setNote(note1);

        User user2 = new User();
        user2.setNote(note2);
        user2.setUsername(username2);

        List<User> userList = new ArrayList<>(16);
        userList.add(user1);
        userList.add(user2);

        int  inserts = userBatchService.insertUsers(userList);
        Map<String, Object> result = new HashMap<>(16);
        result.put("success",inserts > 0);
        result.put("users",userList);
        return result;
    }
}
