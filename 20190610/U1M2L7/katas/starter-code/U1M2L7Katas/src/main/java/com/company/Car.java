package com.company;


import com.company.interfaces.Vehicle;

class Car implements Vehicle {

    @Override
    public void drive(int miles) {

    }

    @Override
    public void displayMilesTraveled() {

    }

    @Override
    public void createEngine() {

    }

    @Override
    public void createTransmission() {

    }

    private String make;
    private String model;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    private int milesTraveled;

}
