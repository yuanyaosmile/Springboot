package com.example.querydslkotlin.dao.entity

import org.apache.commons.lang3.StringUtils
import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "watch")
@IdClass(WatchIdClass::class)
data class WatchEntity(
    @Id
    @Column(name = "brand")
    val brand: String,
    @Id
    @Column(name = "name")
    val name: String,
    @Id
    @Column(name = "color")
    val color: String,
    @Column(name = "stock")
    val stock: Int
)


data class WatchIdClass(
    var brand: String = StringUtils.EMPTY,
    var name: String =  StringUtils.EMPTY,
    var color: String =  StringUtils.EMPTY
) : Serializable