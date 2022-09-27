package com.beanscopedemoapp.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.beanscopedemoapp")//this also works but below demonstrates multiple packages
//@ComponentScan(basePackages = {"com.beanscopedemoapp.proxy","com.beanscopedemoapp.repo","com.beanscopedemoapp.service"})
public class CommentConfig {

}
