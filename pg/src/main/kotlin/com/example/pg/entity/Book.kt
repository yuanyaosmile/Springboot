package com.example.pg.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "books")
data class Book(
    @Id
    val id: String,
    val name: String,
    val count: Int
)
