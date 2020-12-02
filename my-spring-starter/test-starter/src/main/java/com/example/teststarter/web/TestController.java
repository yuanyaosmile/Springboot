package com.example.teststarter.web;

import com.example.yyspringbootstarterautoconfigurer.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    HelloService helloService;

    public TestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return helloService.sayHello("GG");
    }
}
