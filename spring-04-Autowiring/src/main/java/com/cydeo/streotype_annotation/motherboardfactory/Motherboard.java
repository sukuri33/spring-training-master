package com.cydeo.streotype_annotation.motherboardfactory;

import lombok.Getter;

@Getter
public abstract class Motherboard {

    private final String model;
    private final String manufacturer;
    private final int ramSlots;
    private final int cardSlots;
    private final String bios;

    public Motherboard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public abstract void loadProgram(String programName);

}
