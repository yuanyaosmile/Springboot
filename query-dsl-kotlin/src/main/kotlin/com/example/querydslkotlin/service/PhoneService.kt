package com.example.querydslkotlin.service

import com.example.querydslkotlin.dao.entity.PhoneEntity
import com.example.querydslkotlin.dao.entity.QPhoneEntity
import com.example.querydslkotlin.dao.repository.PhoneRepository
import com.querydsl.core.BooleanBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PhoneService @Autowired constructor(
    private val phoneRepository: PhoneRepository
){

    fun getPhone(criteria: String) :Optional<PhoneEntity> {
        val predicate = BooleanBuilder()
        predicate.and(QPhoneEntity.phoneEntity.name.eq(criteria))
        return phoneRepository.findOne(predicate)

    }
}