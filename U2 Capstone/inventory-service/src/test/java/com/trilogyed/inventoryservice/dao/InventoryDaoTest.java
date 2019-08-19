package com.trilogyed.inventoryservice.dao;

import com.trilogyed.inventoryservice.dto.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InventoryDaoTest {

    @Autowired
    InventoryDaoJdbcImpl inventoryDao;

    @Before
    public void setUp() {
        List<Inventory> iList = inventoryDao.getAllInventory();

        for (Inventory i : iList){
            inventoryDao.deleteInventory(i.getInventoryId());
        }
//        iList.stream().
//                forEach(i -> inventoryDao.deleteInventory(i.getInventoryId()));
    }

    @Test
    public void getAddDeleteInvoice() {
        Inventory inventory = new Inventory();
        inventory.setProductId(1);
        inventory.setQuantity(1040);

        inventory = inventoryDao.addInventory(inventory);

        Inventory inventory1 = inventoryDao.getInventory(inventory.getInventoryId());

        assertEquals(inventory1, inventory);

        inventoryDao.deleteInventory(inventory.getInventoryId());

        inventory1 = inventoryDao.getInventory(inventory.getInventoryId());

        assertNull(inventory1);
    }

    @Test
    public void getAllInvoices() {

    }

    @Test
    public void getInvoiceBuProduct() {

    }

    @Test
    public void updateInvoice() {

    }


}
