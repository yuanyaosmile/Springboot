package com.example.dao;

import com.example.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    Product getProduct(Long id);

    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);

}
