package com.example.querydslkotlin.web

import com.example.querydslkotlin.dao.entity.WatchEntity
import com.example.querydslkotlin.service.WatchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.OutputStreamWriter

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

    @GetMapping("/hello")
    fun getHello() {
        var attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        var httpServletResponse = attributes.response!!
        val file = File("hello.csv")
        BufferedReader(FileReader(file)).use { reader ->
            BufferedWriter(OutputStreamWriter(httpServletResponse.outputStream, Charsets.UTF_8)).use { writer ->
                var line:String?
                var count:Int = 0
                while (reader.readLine().also { line = it } != null) {
                    count++
                    writer.write("$count---$line\n")
                }
            }
        }
    }
}