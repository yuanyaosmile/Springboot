package com.example.redis;

public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}
