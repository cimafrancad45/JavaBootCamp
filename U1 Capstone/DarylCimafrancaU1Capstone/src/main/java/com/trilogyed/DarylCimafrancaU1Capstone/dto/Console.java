package com.trilogyed.DarylCimafrancaU1Capstone.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {
  private int consoleId;
  @NotNull
  private String model;
  @NotNull
  private String manufacturer;
  @NotNull
  private String processor;
  @NotNull
  private BigDecimal price;
  @Min(value = 0, message = "Quantity must be a non-negative number.")
  private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public boolean equals(Object c) {
        if (this == null) return true;
        if (c == null || getClass() != c.getClass()) return false;
        Console console = (Console) c;

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
