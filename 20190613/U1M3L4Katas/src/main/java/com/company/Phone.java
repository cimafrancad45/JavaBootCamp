package com.company;

import com.opencsv.bean.CsvBindByName;

public class Phone {
    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "Processor")
    private String processor;
    @CsvBindByName(column = "Storage")
    private Integer storage;
    @CsvBindByName(column = "Price")
    private Integer price;

    public Phone(String brand, String model, String processor, Integer storage, Integer price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.storage = storage;
        this.price = price;
    }

    public Phone(){

    }

    public String getBrand() {
        return brand;
    }

    public Phone setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Phone setModel(String model) {
        this.model = model;
        return this;
    }

    public String getProcessor() {
        return processor;
    }

    public Phone setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public Integer getStorage() {
        return storage;
    }

    public Phone setStorage(Integer storage) {
        this.storage = storage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Phone setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
