package com.company;

public class Accord extends Sedan {

    Engine engine = new Engine();
    Transmission transmission = new Transmission();

    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public void setEngine(Engine engine) {
    }

    public void setTransmission(Transmission transmission) {
    }

    public Object getEngine() {
        return engine;
    }

    public Object getTransmission() {
        return transmission;
    }
}
