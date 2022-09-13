package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.config.ComputerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComputerConfig.class);



    }
}
