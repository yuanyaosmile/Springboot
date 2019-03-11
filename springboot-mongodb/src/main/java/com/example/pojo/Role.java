package com.example.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = -4535385050330679543L;

    private long id;
    @Field("roleName")
    private String roleName;
    private String note;
}
