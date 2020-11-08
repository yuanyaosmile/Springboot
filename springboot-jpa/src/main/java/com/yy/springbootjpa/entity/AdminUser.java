package com.yy.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "adminUser")
@Entity
@Data
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column
    private String password;
}
