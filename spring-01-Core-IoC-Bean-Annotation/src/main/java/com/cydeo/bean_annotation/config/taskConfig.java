package com.cydeo.bean_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class taskConfig {
    @Bean
    public String myStr(){
        return "hello";
    }
    @Bean
    public Integer myInt(){
        return 123;
    }
}
