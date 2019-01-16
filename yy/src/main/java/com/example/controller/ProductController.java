package com.example.controller;

import com.example.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("/purchase")
    public String get(Long userId, Long productId, Integer quantity){
            boolean success = purchaseService.purchase(userId, productId,quantity);
            return success ? "success" : "failed";
    }
}
