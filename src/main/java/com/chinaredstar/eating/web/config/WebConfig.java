package com.chinaredstar.eating.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {




    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        super.addResourceHandlers(registry);
    }



}