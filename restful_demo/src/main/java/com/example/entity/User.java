package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class User {
    public String id;
    public String username;
    public String password;
    public Integer age;
}
