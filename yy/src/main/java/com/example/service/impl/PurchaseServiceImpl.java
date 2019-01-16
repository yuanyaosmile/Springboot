package com.example.service.impl;

import com.example.dao.ProductMapper;
import com.example.dao.PurchaseRecordMapper;
import com.example.pojo.Product;
import com.example.pojo.PurchaseRecord;
import com.example.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private ProductMapper productMapper = null;
    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper = null;
    @Override
    public boolean purchase(Long userId, Long productId, int quantity) {
        Product product= productMapper.getProduct(productId);
        if (product.getStock() < quantity ) {
            return false;
        }
            productMapper.decreaseProduct(productId, quantity);
            PurchaseRecord pr =this. initPurchaseRecord(userId , product , quantity);
            purchaseRecordMapper.insertPurchaseRecord(pr) ;
            return true;
    }

    // 初始化购买信息
    private PurchaseRecord initPurchaseRecord(Long userId, Product product, int quantity) {
        PurchaseRecord pr = new PurchaseRecord();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
