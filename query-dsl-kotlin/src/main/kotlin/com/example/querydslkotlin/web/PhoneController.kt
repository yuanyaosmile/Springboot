package com.example.querydslkotlin.web

import com.example.querydslkotlin.service.PhoneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody

@RestController
class PhoneController @Autowired constructor(
    private val phoneService: PhoneService
){

    @GetMapping("/phone/{criteria}")
    fun getPhone(@PathVariable("criteria") criteria: String) : ResponseEntity<StreamingResponseBody> {

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header("Content-disposition", "attachment; filename=redmi.csv")
            .body(phoneService.getPhone(criteria))
    }
}