package com.company;

import com.sun.xml.internal.ws.api.pipe.Engine;

public class Accord extends Sedan {

    private String year;
    String engine;
    String transmission;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

}
