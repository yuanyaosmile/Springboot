package com.example.querydslkotlin.dao.repository

import com.example.querydslkotlin.dao.entity.WatchEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WatchRepository : JpaRepository<WatchEntity, String> {
    fun findByBrandAndNameAndColor(brand: String, name: String, color: String): WatchEntity
}