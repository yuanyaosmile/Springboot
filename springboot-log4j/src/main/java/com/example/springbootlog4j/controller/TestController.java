package com.example.springbootlog4j.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Barry
 * @date 2018/12/19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger LOGGER = LogManager.getLogger();
    int j = 100;
    @RequestMapping("/log")
    public String test(){
        for( int i = 0; i < j; i++){
            LOGGER.debug("debug" );
            LOGGER.info("info");
            LOGGER.warn("warn");
            LOGGER.error("error");
            LOGGER.fatal("fatal");
        }
        return "hello world";
    }
}
