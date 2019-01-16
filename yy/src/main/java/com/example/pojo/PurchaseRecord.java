package com.example.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@Component
public class PurchaseRecord implements Serializable {
    private static final long serialVersionUID = -515420416212118493L;
    private Long id;
    private Long userId;
    private Long productId;
    private double price;
    private int quantity;
    private double sum;
    private Timestamp purchaseTime;
    private String note;

}
