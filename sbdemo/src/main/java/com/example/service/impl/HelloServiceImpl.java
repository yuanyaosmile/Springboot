package com.example.service.impl;

import com.example.service.HelloService;

/**
 * @Author Barry
 * @date 2019/1/8
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if(name == null || name.trim() == "") {
          throw new RuntimeException("parameter is null");
        }

        System.out.println("Hello " + name );
    }
}
