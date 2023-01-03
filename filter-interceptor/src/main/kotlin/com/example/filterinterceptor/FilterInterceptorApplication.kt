package com.example.filterinterceptor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan(basePackages = ["com.example.filterinterceptor.filter"])
class FilterInterceptorApplication

fun main(args: Array<String>) {
    runApplication<FilterInterceptorApplication>(*args)
}
