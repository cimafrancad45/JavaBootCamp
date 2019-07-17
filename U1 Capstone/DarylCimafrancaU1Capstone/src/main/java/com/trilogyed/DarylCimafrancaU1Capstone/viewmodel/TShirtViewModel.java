package com.trilogyed.DarylCimafrancaU1Capstone.viewmodel;

import com.trilogyed.DarylCimafrancaU1Capstone.dto.TShirt;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirtViewModel {
    private int tShirtId;
    @NotEmpty(message = "Please enter the T-shirt's size.")
    private String size;
    @NotEmpty(message = "Please enter the T-shirt's color.")
    private String color;
    @NotEmpty(message = "Please enter the T-shirt's description.")
    private String description;
    @NotEmpty(message = "Please the T-shirt's price.")
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "9999.99", inclusive = true)
    private BigDecimal price;
    @NotEmpty(message = "Please enter a quantity.")
    @Min(value = 0, message = "Quantity must be a non-negative number.")
    private int quantity;

    public int getTShirtId() {
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
    public boolean equals(Object t) {
        if (this == null) return true;
        if (t == null || getClass() != t.getClass()) return false;
        TShirtViewModel tshirt = (TShirtViewModel) t;

        return tShirtId == tshirt.tShirtId &&
                size.equals(tshirt.size) &&
                color.equals(tshirt.color) &&
                description.equals(tshirt.description) &&
                price.equals(tshirt.price) &&
                quantity == tshirt.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }
}
