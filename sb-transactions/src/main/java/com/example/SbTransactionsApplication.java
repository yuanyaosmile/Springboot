package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.example.dao")
public class SbTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbTransactionsApplication.class, args);
    }

    //注入事务管理器，由Spring boot自动生成
    @Autowired
    PlatformTransactionManager transactionManager = null;
    //使用后初始化方法，观察自动生成的事务管理器
    @PostConstruct
    public void viewTransactionManager(){
        System.out.println(transactionManager.getClass().getName());
    }
}

