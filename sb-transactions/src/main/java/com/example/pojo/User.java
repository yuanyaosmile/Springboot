package com.example.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Author Barry
 * @date 2019/1/9
 */
@Data
@Alias("user")
public class User {
    private int id;
    private String username;
    private String note;
}
