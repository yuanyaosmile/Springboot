package com.example.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author Barry
 * @date 2019/1/7
 */
@Component
@Primary
public class Cat implements Animal{
    @Override
    public void use() {
        System.out.println("cat miao");
    }
}
