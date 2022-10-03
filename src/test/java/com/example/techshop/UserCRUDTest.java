package com.example.techshop;

import com.example.tecshop.model.Product;
import com.example.tecshop.model.User;
import com.example.tecshop.repository.ProductRepository;
import com.example.tecshop.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCRUDTest {

    User user=new User();
    @Before
    public void setUp(){
        user.setUsername("username");
        user.setPassword("12345678");
        user.setEmail("email@gmail.com");
        user.setId((long)10);
    }

    @Test
    public void checkForAdd(){
        Assert.assertTrue(UserValidator.isAddUserValid("username","12345678","email@gmail.com",user));
    }
    @Test
    public void checkForUpdate(){
        user.setPassword("87654321");
        Assert.assertTrue(UserValidator.isUpdateUserValid("username","12345678","email@gmail.com",user));
    }
    @Test
    public void chekForDelete(){
        user.setUsername(null);
        user.setPassword(null);
        user.setEmail(null);
        user.setId(null);
        Assert.assertTrue(UserValidator.isDeleteUserValid(user));
    }
}
