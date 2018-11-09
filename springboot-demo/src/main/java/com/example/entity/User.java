package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by yuanyao on 2018/10/29.
 */
@Getter
@Setter
@Component
public class User {
    public String username;
    public String email;
}
