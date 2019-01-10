package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Barry
 * @date 2019/1/10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    public User insertUser(String userName, String note) {
        User user = new User();
        user.setUsername(userName);
        user.setNote(note);
        userService.insertUser(user);
        return user;
    }

    @RequestMapping("/findUsers")
    public List<User> findUsers(String userName, String note) {
        return userService.findUsers(userName, note);
    }

    @RequestMapping("/updateUserName")
    public Map<String, Object> updateUserName(Long id, String userName){
        User user = userService.updateUserName(id, userName);
        boolean flag = user != null;
        String message = flag ? "success" : "failed";
        return resultMap(flag, message);
    }

    @RequestMapping("/deleteUser")
    public Map<String, Object> deleteUser(Long id) {
        int result = userService.deleteUser(id);
        boolean flag = result == 1;
        String message = flag? "删除成功" : "删除失败";
        return resultMap(flag, message);
    }

    private Map<String, Object> resultMap(boolean success, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", success);
        result.put("message", message);
        return result;
    }
}
