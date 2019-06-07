package com.company;

public class CoffeeMaker {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturer, String model, int carafesize, int cupsLeft, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafesize;
        this.cupsLeft = cupsLeft;
        this.powered = powered;
    }

    //setters
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarafeSize(int carafesize){
        this.carafeSize = carafesize;
    }

    public void setCupsLeft(int cupsLeft){
        this.cupsLeft = cupsLeft;
    }

    public void setPowered (boolean powered) {
        this.powered = powered;
    }

    //getter

    public String getManufacturer(){
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getCarafeSize() {
        return this.carafeSize;
    }

    public int getCupsLeft() {
        return this.cupsLeft;
    }

    public boolean isPowered(){
        return this.powered;
    }
}