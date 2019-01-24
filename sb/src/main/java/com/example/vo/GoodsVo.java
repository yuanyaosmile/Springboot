package com.example.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class GoodsVo {
    private Long id;
    private String goods_name;
    private String goodTitle;
    private String goods_img;
    private String goods_detail;
    private Double goods_price;
    private Integer stock_count;
    private Date start_date;
    private Date end_date;
    private Double miaosha_price;
}
