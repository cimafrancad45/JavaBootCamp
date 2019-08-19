package com.trilogyed.productservice.dao;

import com.trilogyed.productservice.dto.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductDaoTest {

    @Autowired
    ProductDaoJdbcImpl productDaoJdbc;

    @Before
    public void setUp(){
        List<Product> pList = productDaoJdbc.findAllProducts();

        //stream practice, if doesn't work as intended, uncomment following enhanced for loop
        /*
        for (Product p : pList){
            productDaoJdbc.deleteProduct(p.getProductId());
        }
         */

        pList.stream()
                .forEach(p -> productDaoJdbc.deleteProduct(p.getProductId()));
    }

    @Test
    public void getAddDeleteProduct(){
        Product product = new Product();
        product.setProductName("Sony Playstation 4");
        product.setProductDescription("A videogame console manufactured by Sony.");
        product.setListPrice(new BigDecimal("299.99"));
        product.setUnitCost(new BigDecimal("99.99"));

        product = productDaoJdbc.createProduct(product);

        Product product1 = productDaoJdbc.findProduct(product.getProductId());

        assertEquals(product1, product);

        productDaoJdbc.deleteProduct(product.getProductId());

        product1 = productDaoJdbc.findProduct(product.getProductId());

        assertNull(product1);

    }

    @Test
    public void getAllProducts(){
        Product product = new Product();
        product.setProductName("Sony Playstation 4");
        product.setProductDescription("A videogame console manufactured by Sony.");
        product.setListPrice(new BigDecimal("299.99"));
        product.setUnitCost(new BigDecimal("99.99"));

        productDaoJdbc.createProduct(product);

        Product product1 = new Product();
        product1.setProductName("Nintendo Switch");
        product1.setProductDescription("A videogame console manufactured by Nintendo.");
        product1.setListPrice(new BigDecimal("199.99"));
        product1.setUnitCost(new BigDecimal("74.99"));

        productDaoJdbc.createProduct(product1);

        assertEquals(productDaoJdbc.findAllProducts().size(), 2);

    }

    @Test
    public void updateProduct(){
        Product product = new Product();
        product.setProductName("Sony Playstation 4");
        product.setProductDescription("A videogame console manufactured by Sony.");
        product.setListPrice(new BigDecimal("299.99"));
        product.setUnitCost(new BigDecimal("99.99"));

        product = productDaoJdbc.createProduct(product);

        product.setProductName("Nintendo Switch");
        product.setProductDescription("A videogame console manufactured by Nintendo.");
        product.setListPrice(new BigDecimal("199.99"));
        product.setUnitCost(new BigDecimal("74.99"));

        productDaoJdbc.updateProduct(product);

        Product product1 = productDaoJdbc.findProduct(product.getProductId());

        assertEquals(product1, product);

    }

}
