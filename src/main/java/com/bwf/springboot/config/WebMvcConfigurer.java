package com.bwf.springboot.config;

import com.bwf.springboot.controller.interceptor.OneInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("");

        super.addInterceptors(registry);
    }
}
