package com.company;

public class ComputerMouse {

    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;



    public ComputerMouse (String manufacturer, String model, int xPosition, int yPosition, int[] lastClickedLocation){
        this.manufacturer = manufacturer;
        this.model = model;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.lastClickedLocation = lastClickedLocation;
    }

    //setters

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }

    public void setLastClickedLocation(int[] lastClickedLocation){
        this.lastClickedLocation = lastClickedLocation;
    }

    //getter methods

    public String getManufacturer(){
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getxPosition() {
        return this.xPosition;
    }

    public int getyPosition() {
        return this.yPosition;
    }

    public int[] getLastClickedLocation(){
        return this.lastClickedLocation;
    }
}