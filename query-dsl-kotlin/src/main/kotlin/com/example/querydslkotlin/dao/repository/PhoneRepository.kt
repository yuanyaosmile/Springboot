package com.example.querydslkotlin.dao.repository

import com.example.querydslkotlin.dao.entity.PhoneEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface PhoneRepository: JpaRepository<PhoneEntity, String>, QuerydslPredicateExecutor<PhoneEntity>