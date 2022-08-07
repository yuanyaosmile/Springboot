package com.example.querydslkotlin.service

import com.example.querydslkotlin.dao.entity.WatchEntity
import com.example.querydslkotlin.dao.repository.WatchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class WatchService @Autowired constructor(private val watchRepository: WatchRepository) {

    fun save(watchEntity: WatchEntity): WatchEntity {
        watchRepository.save(watchEntity)
        return watchRepository.findOne(Example.of(watchEntity)).get()
    }

    fun getWatch(brand: String, name: String, color: String): WatchEntity {
        return watchRepository.findByBrandAndNameAndColor(brand, name, color)
    }
}