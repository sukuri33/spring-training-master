package com.cydeo.streotype_annotation.casefactory;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class Case {

    private final String model;
    private final String manufacturer;
    private final String powerSupply;
    @Autowired
    private Dimensions dimensions;

    public Case(String model, String manufacturer, String powerSupply) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
    }

    public abstract void pressPowerButton();

}
