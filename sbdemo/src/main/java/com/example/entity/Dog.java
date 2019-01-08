package com.example.entity;

import org.springframework.stereotype.Component;

/**
 * @Author Barry
 * @date 2019/1/7
 */
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("dog barks");
    }
}
