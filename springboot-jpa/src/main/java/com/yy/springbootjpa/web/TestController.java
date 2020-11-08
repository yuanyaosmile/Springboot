package com.yy.springbootjpa.web;

import com.yy.springbootjpa.dao.AdminUserRepository;
import com.yy.springbootjpa.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    AdminUserService adminUserService;

    protected TestController(AdminUserService adminUserService){
        this.adminUserService = adminUserService;
    }


    @GetMapping("/hello")
    public String test(){
        return adminUserService.getAdminUserById(1).toString();
    }


}
