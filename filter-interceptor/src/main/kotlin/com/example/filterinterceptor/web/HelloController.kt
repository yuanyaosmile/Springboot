package com.example.filterinterceptor.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/test/hello")
    fun test(): String {
        println("hello from the other side")
        return "hello from the other side"
    }
}