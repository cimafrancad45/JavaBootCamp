package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturer, String model, int numSpeakers, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeakers = numSpeakers;
        this.station = station;
        this.volume = volume;
        this.powered = powered;
    }

    //setters

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumSoeakers(int numSpeaker) {
        this.numSpeakers = numSpeaker;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void isPowered(boolean powered) {
        this.powered = powered;
    }

    //getters
    public String getModel() {
        return this.model;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public int getNumSpeakers() {
        return this.numSpeakers;
    }

    public String getStation() {
        return this.station;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isPowered(){
    return this.powered;
    }
}
