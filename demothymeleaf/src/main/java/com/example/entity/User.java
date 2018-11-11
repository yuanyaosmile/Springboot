package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class User {
    public String username;
    public String password;
}
