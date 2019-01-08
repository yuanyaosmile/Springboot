package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@Component
@Setter
@Getter
public class User {
    private String username;
    private String password;
}
