package com.example;

import com.example.entity.*;
import com.example.service.HelloService;
import com.example.service.impl.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
       // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoApplication.class);
//        Person person = ctx.getBean(BussnessPerson.class);
//        person.service();

       /* HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService)ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("zhangsan");
        System.out.println("\n###############name is null!!#############\n");
        proxy.sayHello(null);*/
    }

}

