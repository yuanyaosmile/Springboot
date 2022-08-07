package com.example.querydslkotlin.service

import com.example.querydslkotlin.dao.entity.QPhoneEntity
import com.example.querydslkotlin.dao.repository.PhoneRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.querydsl.core.BooleanBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody


@Service
class PhoneService @Autowired constructor(
    private val phoneRepository: PhoneRepository
) {
    private val objectMapper: ObjectMapper = ObjectMapper()

    fun getPhone(criteria: String): StreamingResponseBody {
        val predicate = BooleanBuilder()
        predicate.and(QPhoneEntity.phoneEntity.name.eq(criteria))
        val phone = phoneRepository.findOne(predicate)

        return StreamingResponseBody { outputStream ->
            for (i in 0 until 5) {
                outputStream.write(objectMapper.writeValueAsBytes(phone.get()))
            }
        }
    }
}