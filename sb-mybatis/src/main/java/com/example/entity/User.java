package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@Getter
@Setter
@Component
public class User {
    private long id ;
    private String username;
    private SexEnum sex;
    private String note;

    public User (){

    }
}
