package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.ComputerConfigAutowiring.ConfigClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTestAutowiring {

    public static void main(String[] args) {


        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigClass.class);

        PC myPC = container.getBean(PC.class);
        myPC.powerUp();


    }


}
