package com.trilogyed.inventoryservice.dao;

import com.trilogyed.inventoryservice.dto.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InventoryDaoJdbcImpl implements InventoryDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public InventoryDaoJdbcImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //prepared statements
    public static final String ADD_INVENTORY_SQL =
            "insert into inventory (product_id, quantity) values (?,?)";

    public static final String GET_INVENTORY_SQL =
            "select * from inventory where inventory_id = ?";

    public static final String GET_INVENTORY_BY_PRODUCT_SQL =
            "select * from inventory where product_id = ?";

    public static final String GET_ALL_INVENTORIES =
            "select * from inventory";

    public static final String UPDATE_INVENTORY =
            "update inventory set product_id = ? , quantity = ?";

    public static final String DELETE_INVENTORY =
            "delete from inventory where inventory_id = ?";

    @Override
    public Inventory addInventory(Inventory inventory){
        jdbcTemplate.update(ADD_INVENTORY_SQL,
                inventory.getProductId(),
                inventory.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        inventory.setInventoryId(id);
        return inventory;
    }

    @Override
    public Inventory getInventory(int id){
        try {
            return jdbcTemplate.queryForObject(GET_INVENTORY_SQL, this::mapRowToInventory, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Inventory getInventoryByProduct(int id){
        try {
            return jdbcTemplate.queryForObject(GET_INVENTORY_BY_PRODUCT_SQL, this::mapRowToInventory, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Inventory> getAllInventory(){
        return jdbcTemplate.query(GET_ALL_INVENTORIES, this::mapRowToInventory);
    }

    @Override
    public void updateInventory(Inventory inventory){
        jdbcTemplate.update(UPDATE_INVENTORY,
                inventory.getProductId(),
                inventory.getQuantity(),
                inventory.getInventoryId());
    }

    @Override
    public void deleteInventory(int id){
        jdbcTemplate.update(DELETE_INVENTORY, id);

    }

    private Inventory mapRowToInventory(ResultSet rs, int rowNum) throws SQLException {
        Inventory inventory = new Inventory();

        inventory.setInventoryId(rs.getInt("inventory_id"));
        inventory.setInventoryId(rs.getInt("product_id"));
        inventory.setInventoryId(rs.getInt("quantity"));

        return inventory;
    }
}
