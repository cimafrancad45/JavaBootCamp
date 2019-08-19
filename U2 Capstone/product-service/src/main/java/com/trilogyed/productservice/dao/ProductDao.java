package com.trilogyed.productservice.dao;

import com.trilogyed.productservice.dto.Product;

import java.util.List;

public interface ProductDao {

    Product createProduct(Product product);
    Product findProduct(int id);
    List<Product> findAllProducts();
    void updateProduct(Product product);
    void deleteProduct(int id);
}
