package com.example.querydslkotlin.web

import com.example.querydslkotlin.dao.entity.WatchEntity
import com.example.querydslkotlin.service.WatchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WatchController @Autowired constructor(
    private val watchService: WatchService
) {
    @GetMapping("/watch")
    fun getWatch(
        @RequestParam brand: String,
        @RequestParam name: String,
        @RequestParam color: String
    ): ResponseEntity<WatchEntity> {
        return ResponseEntity.ok(watchService.getWatch(brand, name, color))
    }
}