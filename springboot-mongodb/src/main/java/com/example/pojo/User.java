package com.example.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Document
@Getter
@Setter
@ToString
@Component
public class User implements Serializable {

    private static final long serialVersionUID = 6222176558369919436L;

    @Id
    private long id;
    @Field("username")
    private String username;

    private String note;

    private List<Role> roles;
}
