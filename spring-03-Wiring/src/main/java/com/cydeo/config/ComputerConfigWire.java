package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfigWire {

    @Bean
    public Dimensions dimensions(){
        return new Dimensions(12,45,11);
    }

    @Bean
    public Case caseDell(Dimensions dimensions){
        return new DellCase("220B","Dell","240V",dimensions);
    }
}
