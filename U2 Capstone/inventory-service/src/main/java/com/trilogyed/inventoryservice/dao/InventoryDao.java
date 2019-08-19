package com.trilogyed.inventoryservice.dao;

import com.trilogyed.inventoryservice.dto.Inventory;

import java.util.List;

public interface InventoryDao {

    Inventory addInventory(Inventory inventory);
    Inventory getInventory(int id);
    Inventory getInventoryByProduct(int id);
    List<Inventory> getAllInventory();
    void updateInventory(Inventory inventory);
    void deleteInventory(int id);

}
