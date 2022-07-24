package com.example.querydsljava.dao.repository;

import com.example.querydsljava.dao.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PhoneRepository extends JpaRepository<PhoneEntity, String>, QuerydslPredicateExecutor<PhoneEntity> {

}
