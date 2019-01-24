package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
//@AllArgsConstructor
public class User {
    private int id;
    private String username;
}
