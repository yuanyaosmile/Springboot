package com.example.pojo;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author Barry
 * @date 2019/1/10
 */
@Alias("user")
@Component
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = -5219692733789280884L;
    private long id;
    private String username;
    private String note;
}
