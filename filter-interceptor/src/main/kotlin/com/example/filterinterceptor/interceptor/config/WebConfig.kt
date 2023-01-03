package com.example.filterinterceptor.interceptor.config

import com.example.filterinterceptor.interceptor.CustomerInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport


@Configuration
class WebConfig: WebMvcConfigurationSupport() {

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)

        val pathPatterns = "/test/**"

        val excludePathPatterns = "/api/**"

        registry.addInterceptor(CustomerInterceptor()).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns)
    }
}