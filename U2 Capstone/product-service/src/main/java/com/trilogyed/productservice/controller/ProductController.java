package com.trilogyed.productservice.controller;

import com.trilogyed.productservice.dao.ProductDao;
import com.trilogyed.productservice.dao.ProductDaoJdbcImpl;
import com.trilogyed.productservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductDaoJdbcImpl productDaoJdbc;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return productDaoJdbc.createProduct(product);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProduct(@PathVariable int id){
        if (productDaoJdbc.findProduct(id) == null){
            return null;
        }
        return productDaoJdbc.findProduct(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts(){
        return productDaoJdbc.findAllProducts();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product){
        productDaoJdbc.updateProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id){
        productDaoJdbc.deleteProduct(id);
    }


}
