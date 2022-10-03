package com.example.techshop;

import com.example.tecshop.model.Role;
import com.example.tecshop.model.User;
import com.example.tecshop.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;


public class TestUsers {

    User user=new User();
    @Before
    public void setUp(){
        user.setUsername("username");
        user.setPassword("12345678");
        user.setEmail("email@gmail.com");
        user.setId((long)10);
    }

    @Test
    public void checkUsernameForLength(){
        Assert.assertTrue(UserValidator.checkForLength(user.getUsername(),3,20));
    }
    @Test
    public void checkUsernameForCyrillic(){
        Assert.assertTrue(UserValidator.checkForCyrillic(user.getUsername()));
    }
    @Test
    public void checkUsernameForNull(){
        Assert.assertTrue(UserValidator.checkForCyrillic(user.getUsername()));
    }
    @Test
    public void checkPasswordForCyrillic(){
        Assert.assertTrue(UserValidator.checkForCyrillic(user.getPassword()));
    }
    @Test
    public void checkPasswordForLength(){
        Assert.assertTrue(UserValidator.checkForLength(user.getPassword(),6,120));
    }
    @Test
    public void checkPasswordForNull(){
        Assert.assertTrue(UserValidator.checkForNull(user.getPassword()));
    }
    @Test
    public void checkEmailForNull(){
        Assert.assertTrue(UserValidator.checkForNull(user.getEmail()));
    }

    @Test
    public void checkIdForNull(){
        Assert.assertTrue(UserValidator.checkForNull(user.getId().toString()));
    }

    @Test
    public void checkUsernameForFalseLength(){
        user.setUsername("ab");
        Assert.assertFalse(UserValidator.checkForLength(user.getUsername(),3,20));
    }
    @Test
    public void checkUsernameForFalseCyrillic(){
        user.setUsername("фпрро");
        Assert.assertFalse(UserValidator.checkForCyrillic(user.getUsername()));
    }

    @Test
    public void checkPasswordForFalseCyrillic(){
        user.setPassword("1234567рр");
        Assert.assertFalse(UserValidator.checkForCyrillic(user.getPassword()));
    }
    @Test
    public void checkPasswordForFalseLength(){
        user.setPassword("12");
        Assert.assertFalse(UserValidator.checkForLength(user.getPassword(),6,120));
    }

    @Test
    public void checkUsernameForTrueLength(){
        user.setUsername("hdsjfgjsdbfjhbsdjfbdfdsfbfjsdbjf");
        Assert.assertFalse(UserValidator.checkForLength(user.getUsername(),3,20));
    }
    @Test
    public void checkUsernameForTrueCyrillic(){
        user.setUsername("noCyrillic");
        Assert.assertTrue(UserValidator.checkForCyrillic(user.getUsername()));
    }

    @Test
    public void checkPasswordForTrueCyrillic(){
        user.setPassword("12345678");
        Assert.assertTrue(UserValidator.checkForCyrillic(user.getPassword()));
    }
    @Test
    public void checkPasswordForTrueLength(){
        user.setPassword("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        Assert.assertFalse(UserValidator.checkForLength(user.getPassword(),6,120));
    }
}
