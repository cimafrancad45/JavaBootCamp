package com.trilogyed.inventoryservice.dto;

import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

public class Inventory {

    private int inventoryId;
    private int productId;
    private int quantity;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(this == null || getClass() != o.getClass())
        return false;
        Inventory i = (Inventory) o;
        return inventoryId == i.inventoryId &&
                productId == i.productId &&
                quantity == i.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, productId, quantity);
    }

}
