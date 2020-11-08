package com.yy.springbootjpa.service.impl;

import com.yy.springbootjpa.dao.AdminUserRepository;
import com.yy.springbootjpa.entity.AdminUser;
import com.yy.springbootjpa.service.AdminUserService;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    AdminUserRepository adminUserRepository;

    protected AdminUserServiceImpl(AdminUserRepository adminUserRepository){
        this.adminUserRepository = adminUserRepository;
    }

    @Override
    public AdminUser getAdminUserById(Integer id) {
        return adminUserRepository.getOne(id);
    }
}
