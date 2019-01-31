package com.example.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Setter
@Getter
@Document
public class User implements Serializable {
    private static final long serialVersionUID = -1010367199701418044L;

    @Id
    private long id;

    @Field("username")
    private String username;
    private String note;
}
