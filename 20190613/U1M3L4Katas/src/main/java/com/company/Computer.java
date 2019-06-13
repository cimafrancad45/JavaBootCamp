package com.company;

import com.opencsv.bean.CsvBindByName;

public class Computer {

    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "CPU")
    private String cpu;
    @CsvBindByName(column = "RAM")
    private Integer ram;
    @CsvBindByName(column = "StorageSize")
    private Integer storageSize;

    public Computer(String brand, String model, String cpu, Integer ram, Integer storageSize) {
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.storageSize = storageSize;
    }

    public Computer() {
    }

    public String getBrand() {
        return brand;
    }

    public Computer setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Computer setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCpu() {
        return cpu;
    }

    public Computer setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public Integer getRam() {
        return ram;
    }

    public Computer setRam(Integer ram) {
        this.ram = ram;
        return this;
    }

    public Integer getStorageSize() {
        return storageSize;
    }

    public Computer setStorageSize(Integer storageSize) {
        this.storageSize = storageSize;
        return this;
    }
}
