package com.example.dao;

import com.example.pojo.PurchaseRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRecordMapper {
     int insertPurchaseRecord(PurchaseRecord pr);
}
