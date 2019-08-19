package com.trilogyed.productservice.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private int productId;
    @NotNull(message = "Input required.")
    private String productName;
    @NotNull(message = "Input required.")
    private String productDescription;
    @PositiveOrZero(message = "Price must be zero or more.")
    private BigDecimal listPrice;
    @PositiveOrZero(message = "Price must be zero or more.")
    private BigDecimal unitCost;



    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal cost) {
        this.unitCost = cost;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this == null || getClass() != o.getClass())
            return false;
        Product p = (Product) o;
            return productId == p.getProductId() &&
                    Objects.equals(productName, p.getProductName()) &&
                    Objects.equals(productDescription, p.getProductDescription()) &&
                    Objects.equals(listPrice, p.getListPrice()) &&
                    Objects.equals(unitCost, p.getUnitCost());

    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productDescription, listPrice, unitCost);
    }
}
