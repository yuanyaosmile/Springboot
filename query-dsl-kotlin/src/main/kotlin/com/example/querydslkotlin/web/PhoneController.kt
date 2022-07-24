package com.example.querydslkotlin.web

import com.example.querydslkotlin.dao.entity.PhoneEntity
import com.example.querydslkotlin.service.PhoneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PhoneController @Autowired constructor(
    private val phoneService: PhoneService
){

    @GetMapping("/phone/{criteria}")
    fun getPhone(@PathVariable("criteria") criteria: String) : ResponseEntity<PhoneEntity> {
        return ResponseEntity.of(phoneService.getPhone(criteria))
    }
}