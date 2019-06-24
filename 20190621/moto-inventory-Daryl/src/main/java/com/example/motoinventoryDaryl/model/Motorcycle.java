package com.example.motoinventoryDaryl.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Motorcycle {

    private int id;
    @NotEmpty(message = "You must supply a value for VIN.")
    @Size(min = 5, max = 5, message = "Your VIN should be at 5 characters long.")
    private String vin;
    @NotEmpty(message = "You must supply a value for make.")
    private String make;
    @NotEmpty(message = "You must supply a value for model.")
    private String model;
    @NotEmpty(message ="You most supply a enter a value for year.")
    private String year;
    @NotEmpty(message = "You must supply a value for color.")
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}