package com.example.redis.service;

import com.example.redis.BasePrefix;

public class GoodsKey extends BasePrefix {

    public GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey(60, "gl");

    public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");
}
