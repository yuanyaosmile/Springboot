package com.example.pojo;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Setter
@Getter
//@Alias("product")
@Component
public class Product implements Serializable {
    private static final long serialVersionUID = -4912851169538491158L;

    private Long id;
    private String productName;
    private int stock;
    private double price;
    private int version;
    private String note;
}
