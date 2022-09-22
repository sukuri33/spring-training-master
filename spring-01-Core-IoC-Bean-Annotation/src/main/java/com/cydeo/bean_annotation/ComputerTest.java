package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.taskConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {

        System.out.println("***********************Creating Container********************");
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, taskConfig.class);


        System.out.println("*******************Retrieving the Beans");
//        Monitor theMonitor = container.getBean(Monitor.class);//Complains, because there are more than one monitor in ComputerConfig,
//                                                                so Spring is confused which one you are trying to get?
//        Monitor theMonitor = container.getBean(SonyMonitor.class);//Solution#1
//        Monitor theMonitor = container.getBean("monitorSony",Monitor.class);//Solution#2
                                                                                   // getBean has multiple overloaded methods
                                                                                   // and this one asks Bean name(Spring,by default, treats method name as Bean name to uniquely identify the desired Bean)
                                                                                   // and the Parent class - Monitor.class

//        Monitor theMonitor = container.getBean("Sony",Monitor.class);//Solution#3 in the ComputerConfig give your own custom Bean name
        Monitor theMonitor = container.getBean(Monitor.class);//At this point this line won't complain because we used Primary annotation for Acer Monitor
        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

        PC myPc = new PC(theCase,theMonitor,theMotherboard);

        myPc.powerUp();
        System.out.println("Target Monitor Bean is "+theMonitor.getClass().getSimpleName());



    }
}
