package com.example.springbootlog4j2.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Barry
 * @date 2018/12/20
 */
@RestController
@Slf4j
public class HelloController {

    /**
     * log4  1.8的jar获取Logger的方式，与之前略有不同
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * 传统方式使用log4j
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.error("error");
        LOGGER.fatal("fatal");
        LOGGER.warn("Warn");
        return "hello world!";
    }

    /**
     * 使用lombok的@Slf4j注解，直接使用log即可
     * @return
     */
    @RequestMapping("/hi")
    public String hi() {
        log.info("info from @Slf4j");
        log.debug("debug from @slf4j");
        log.error("error from @slf4j");
        log.warn("warn from @slf4j");
        return "Hi";
    }
}
