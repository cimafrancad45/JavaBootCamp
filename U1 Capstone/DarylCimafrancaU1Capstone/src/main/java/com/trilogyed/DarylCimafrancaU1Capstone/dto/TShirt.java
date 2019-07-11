package com.trilogyed.DarylCimafrancaU1Capstone.dto;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {
    private int tShirtId;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    @Min(value = 1, message = "Quanitity must not be a negative number!")
    private int quantity;

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public boolean equals(Object g) {
        if (this == null) return true;
        if (g == null || getClass() != g.getClass()) return false;
        Game game = (Game) g;

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
