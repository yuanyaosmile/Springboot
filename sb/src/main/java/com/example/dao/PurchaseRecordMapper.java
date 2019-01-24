package com.example.dao;

import com.example.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface PurchaseRecordMapper {
    int insertPurchaseRecord(PurchaseRecord pr);
}
