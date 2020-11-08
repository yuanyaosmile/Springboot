package com.yy.springbootjpa.dao;

import com.yy.springbootjpa.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser,Integer> {
}
