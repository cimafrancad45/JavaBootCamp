package com.trilogyed.productservice.dao;


import com.trilogyed.productservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDaoJdbcImpl implements ProductDao {
    //JdbcTemplate implementation
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoJdbcImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //prepared statements
    private static final String CREATE_PRODUCT_SQL =
            "insert into product (product_name, product_description, list_price, unit_cost) values (?,?,?,?)";

    private static final String FIND_PRODUCT_SQL =
            "select * from product where product_id = ?";

    private static final String FIND_ALL_PRODUCTS =
            "select * from product";

    private static final String UPDATE_PRODUCT =
            "update product set product_name = ?, product_description = ?, list_price = ?, unit_cost = ? where product_id = ?";

    private static final String DELETE_PRODUCT =
            "delete from product where product_id = ?";


    @Override
    public Product createProduct(Product product){
        jdbcTemplate.update(CREATE_PRODUCT_SQL,
                product.getProductName(),
                product.getProductDescription(),
                product.getListPrice(),
                product.getUnitCost());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        product.setProductId(id);
        return product;
    }

    @Override
    public Product findProduct(int id){
        try {
            return jdbcTemplate.queryForObject(FIND_PRODUCT_SQL, this::mapRowToProduct, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Product> findAllProducts(){
        return jdbcTemplate.query(FIND_ALL_PRODUCTS, this::mapRowToProduct);
    }

    @Override

    public void updateProduct(Product product){

        jdbcTemplate.update(UPDATE_PRODUCT,
                product.getProductName(),
                product.getProductDescription(),
                product.getListPrice(),
                product.getUnitCost(),
                product.getProductId());


    }

    @Override
    public void deleteProduct(int id){

        jdbcTemplate.update(DELETE_PRODUCT, id);

    }


    public Product mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setProductDescription(rs.getString("product_description"));
        product.setListPrice(rs.getBigDecimal("list_price"));
        product.setUnitCost(rs.getBigDecimal("unit_cost"));


        return product;
    }

}
