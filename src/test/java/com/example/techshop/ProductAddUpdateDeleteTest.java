package com.example.techshop;

import com.example.tecshop.model.Product;
import com.example.tecshop.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductAddUpdateDeleteTest {
    @Autowired
    private static ProductRepository productRepository;
    Product product=new Product();
    @Before
    public void setUp(){
        product.setFirstName("Fridge");
        product.setLastName("100");
        product.setId(10);
        product.setEmailId("10");
        product.setImageUrl("url");
    }

    @Test
    public void checkForAdd(){
        Assert.assertTrue(ProductValidator.isAddUserValid("Fridge","100","10","url",product));
    }
    @Test
    public void checkForUpdate(){
        product.setLastName("200");
        Assert.assertTrue(ProductValidator.isUpdateUserValid("Fridge","100","10","url",product));
    }
    @Test
    public void chekForDelete(){
        product.setFirstName(null);
        product.setLastName(null);
        product.setId(10);
        product.setEmailId(null);
        product.setImageUrl(null);
        Assert.assertTrue(ProductValidator.isDeleteUserValid(product));
    }
}
