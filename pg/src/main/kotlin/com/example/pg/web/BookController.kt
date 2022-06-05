package com.example.pg.web

import com.example.pg.entity.Book
import com.example.pg.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(private val bookService: BookService) {

    @GetMapping("/ids/{id}")
    fun getBookById( @PathVariable("id") id: String):ResponseEntity<Book> {
        return ResponseEntity.of(bookService.getBookById(id))
    }

    @GetMapping("/names/{name}")
    fun getBookByName( @PathVariable("name") name: String):ResponseEntity<Book> {
        return ResponseEntity.ok(bookService.getBookByName(name))
    }
}