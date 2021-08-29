package com.example.helloworld.web;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    private KafkaTemplate<String, Object> kafkaTemplate;

    public HelloController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/kafka/normal/{msg}")
    public void sendMessage(@PathVariable("msg") String msg) {
        kafkaTemplate.send("hello-world", msg);
    }
}
