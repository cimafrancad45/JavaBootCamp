package com.darylcorp;

import com.opencsv.bean.CsvBindByName;

public class Television {
    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "Price")
    private Integer price;
    @CsvBindByName(column = "ScreenSize")
    private Integer screenSize;

    public String getBrand() {
        return brand;
    }

    public Television setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Television setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Television setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getScreenSize() {
        return screenSize;
    }

    public Television setScreenSize(Integer screenSize) {
        this.screenSize = screenSize;
        return this;
    }
}
