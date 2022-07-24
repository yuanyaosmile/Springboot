package com.example.querydslkotlin.dao.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "phone")
data class PhoneEntity(
    @Id
    @Column(name="id")
    val id: String,
    @Column(name = "name")
    val name: String,
    @Column (name="brand")
    val brand: String
)
