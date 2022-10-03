package com.example.techshop;

import com.example.tecshop.model.Product;
import com.example.tecshop.model.User;
import com.example.tecshop.repository.ProductRepository;
import com.example.tecshop.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestProducts {

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
    public void checkNameForLength(){
        Assert.assertTrue(ProductValidator.checkForLength(product.getFirstName(),3,100));
    }
    @Test
    public void checkNameForNull(){
        Assert.assertTrue(ProductValidator.checkForNull(product.getFirstName()));
    }
    @Test
    public void checkNameForFalseSymbols(){
        Assert.assertTrue(ProductValidator.checkForFalseSymbols(product.getFirstName()));
    }
    @Test
    public void checkPriceForLength(){
        Assert.assertTrue(ProductValidator.checkForLength(product.getLastName(),1,10));
    }
    @Test
    public void checkPriceForNull(){
        Assert.assertTrue(ProductValidator.checkForNull(product.getLastName()));
    }
    @Test
    public void checkPriceForLetters(){
        Assert.assertTrue(ProductValidator.checkForNumbers(product.getLastName()));
    }
    @Test
    public void checkEmailForNull(){
        Assert.assertFalse(product.getEmailId()==null);
    }
    @Test
    public void checkImageForNull(){
        Assert.assertFalse(product.getImageUrl()==null);
    }


    @Test
    public void checkNameForFalseLength(){
        product.setFirstName("a");
        Assert.assertFalse(ProductValidator.checkForLength(product.getFirstName(),3,100));
    }

    @Test
    public void checkNameForFalseFalseSymbols(){
        product.setFirstName("fbksdbf2`~sf");
        Assert.assertFalse(ProductValidator.checkForFalseSymbols(product.getFirstName()));
    }
    @Test
    public void checkPriceForFalseLength(){
        product.setLastName("10000000000000000000000000000000");
        Assert.assertFalse(ProductValidator.checkForLength(product.getLastName(),1,10));
    }

    @Test
    public void checkPriceForFalseLetters(){
        product.setLastName("asdd");
        Assert.assertFalse(ProductValidator.checkForNumbers(product.getLastName()));
    }


    @Test
    public void checkNameFoTrueLength(){
        product.setFirstName("adfdfdf");
        Assert.assertTrue(ProductValidator.checkForLength(product.getFirstName(),3,100));
    }

    @Test
    public void checkNameForSymbols(){
        product.setFirstName("aaaaaaaaaaa");
        Assert.assertTrue(ProductValidator.checkForFalseSymbols(product.getFirstName()));
    }
    @Test
    public void checkPriceForTrueLength(){
        product.setLastName("");
        Assert.assertFalse(ProductValidator.checkForLength(product.getLastName(),1,10));
    }

    @Test
    public void checkPriceForTrueLetters(){
        product.setLastName("100$");
        Assert.assertFalse(ProductValidator.checkForNumbers(product.getLastName()));
    }
}
