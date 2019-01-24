package com.example.service;

public interface PurchaseService {
    boolean purchase(Long userId, Long productId, int quantity);
}
