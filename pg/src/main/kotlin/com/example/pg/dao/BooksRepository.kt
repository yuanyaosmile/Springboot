package com.example.pg.dao

import com.example.pg.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BooksRepository : JpaRepository<Book, String> {
    fun getBookByName(name: String):Book
}