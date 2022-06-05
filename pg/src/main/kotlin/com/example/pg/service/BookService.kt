package com.example.pg.service

import com.example.pg.dao.BooksRepository
import com.example.pg.entity.Book
import org.springframework.stereotype.Service
import java.util.*


@Service
class BookService(
    private val booksRepository: BooksRepository
) {

    fun getBookById(id: String): Optional<Book> {
        return booksRepository.findById(id)
    }

    fun getBookByName(name: String): Book {
        return booksRepository.getBookByName(name)
    }
}