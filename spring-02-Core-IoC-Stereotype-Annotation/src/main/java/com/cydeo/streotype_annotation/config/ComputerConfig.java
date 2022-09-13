package com.cydeo.streotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//We are telling spring to scan, in this case, by default it will scan the package where this class is resided
//However, under config package there is no any other classes to be scanned
//Hence
@ComponentScan(basePackages = "com.cydeo")//TIP: you can omit "basePackages =" only put root package as a string
//you can also put other packages if you want
//you can also put the full package path "com.cydeo.streotype_annotation"
public class ComputerConfig {
}
