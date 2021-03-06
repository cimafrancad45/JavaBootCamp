package com.company;

public class Microwave {

    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave(String manufacturer, String model, int secondsLeft, String time, boolean running){
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = secondsLeft;
        this.time = time;
        this.running = running;
    }

    //setters

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setSecondsLeft(int secondsLeft){
        this.secondsLeft = secondsLeft;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    //getters

    public String getManufacturer(){
        return this.manufacturer;
    }

    public String getModel(){
        return this.model;
    }

    public int getSecondsLeft(){
        return this.secondsLeft;
    }

    public String getTime(){
        return this.time;
    }

    public boolean isRunning(){
        return this.running;
    }
}
