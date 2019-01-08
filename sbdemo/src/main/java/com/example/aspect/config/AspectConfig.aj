package com.example.aspect.config;

import com.example.aspect.MyAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@Configuration
@EnableAspectJAutoProxy
public aspect AspectConfig {
    @Bean("myAspect")
    public MyAspect getMyAspect(){
        return new MyAspect();
    }
}
