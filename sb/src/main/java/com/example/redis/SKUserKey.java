package com.example.redis;

public class SKUserKey extends BasePrefix{

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    public SKUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static SKUserKey token = new SKUserKey(TOKEN_EXPIRE, "tk");
}
