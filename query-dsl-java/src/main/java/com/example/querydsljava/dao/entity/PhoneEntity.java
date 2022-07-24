package com.example.querydsljava.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "phone")
public class PhoneEntity {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
}
