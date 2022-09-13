package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.config.ComputerConfig;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComputerConfig.class);

        Monitor theMonitor = context.getBean(Monitor.class);
        Case theCase = context.getBean(Case.class);
        Motherboard theMotherboard = context.getBean(Motherboard.class);
        PC myPc = new PC(theCase,theMonitor,theMotherboard);

        myPc.powerUp();
        System.out.println("Target Monitor Bean is "+theMonitor.getClass().getSimpleName());



    }
}
