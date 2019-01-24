package com.example.dao;

import com.example.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface ProductMapper {

    Product getProduct(Long id);

    //减少库存，用@Param标明mybatis参数传递给后台
    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
}
