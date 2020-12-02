package com.yy.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
}
