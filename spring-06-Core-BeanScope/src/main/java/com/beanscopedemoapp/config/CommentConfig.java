package com.beanscopedemoapp.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.easytask")//this also works but below demonstrates multiple packages
//@ComponentScan(basePackages = {"com.easytask.proxy","com.easytask.repo","com.easytask.service"})
public class CommentConfig {

}
