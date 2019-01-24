package com.example.config;

import com.example.dao.ProductMapper;
import com.example.dao.PurchaseRecordMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Autowired
    SqlSessionFactory sqlSessionFactory ;

    @Bean("productMapper")
    public MapperFactoryBean<ProductMapper> productMapper(){
        MapperFactoryBean<ProductMapper> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setMapperInterface(ProductMapper.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
        return mapperFactoryBean;
    }

    @Bean("purchaseRecordMapper")
    public MapperFactoryBean<PurchaseRecordMapper> purchaseRecordMapper(){
        MapperFactoryBean<PurchaseRecordMapper> mapper = new MapperFactoryBean<>();
        mapper.setMapperInterface(PurchaseRecordMapper.class);
        mapper.setSqlSessionFactory(sqlSessionFactory);
        return mapper;
    }
}
