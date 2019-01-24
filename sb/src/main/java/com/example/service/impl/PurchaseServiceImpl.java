package com.example.service.impl;

import com.example.dao.ProductMapper;
import com.example.dao.PurchaseRecordMapper;
import com.example.pojo.Product;
import com.example.pojo.PurchaseRecord;
import com.example.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Override
    @Transactional
    public boolean purchase(Long userId, Long productId, int quantity) {
        Product product = productMapper.getProduct(productId);

        if (product.getStock() < quantity) {
            return false;
        }

        int mm = productMapper.decreaseProduct(productId, quantity);
        log.debug("更新的结果是：  " + mm);

        PurchaseRecord purchaseRecord = this.initPurchaseRecord(userId, product, quantity);
        purchaseRecordMapper.insertPurchaseRecord(purchaseRecord);
        return true;
    }

    private PurchaseRecord initPurchaseRecord(Long userId, Product product, int quantity){
        PurchaseRecord purchaseRecord = new PurchaseRecord();
        purchaseRecord.setNote("购买时间为： " + System.currentTimeMillis());
        purchaseRecord.setPrice(product.getPrice());
        purchaseRecord.setProductId(product.getId());
        purchaseRecord.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        purchaseRecord.setSum(sum);
        purchaseRecord.setUserId(userId);
        return purchaseRecord;
    }
}
