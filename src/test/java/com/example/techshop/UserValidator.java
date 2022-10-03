package com.example.techshop;

import com.example.tecshop.model.Product;
import com.example.tecshop.model.User;
import com.example.tecshop.repository.ProductRepository;
import com.example.tecshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UserValidator {
    @Autowired
    private static UserRepository userRepository;

    public static boolean isAddUserValid(String username,
                                         String email, String password, User user){
        boolean isValid=false;
        if(user.getUsername()==username ||
                user.getPassword()==password ||
                user.getEmail()==email){
            isValid=true;
        }
        return isValid;
    }
    public static boolean isUpdateUserValid(String username,
                                            String email, String password, User updatedUser){
        if(updatedUser.getUsername()==username &&
                updatedUser.getPassword()==password &&
                updatedUser.getEmail()==email){
            return false;
        }
        return true;
    }
    public static boolean isDeleteUserValid(User user){
        boolean isValid=false;
        if(user.getUsername()==null ||
                user.getPassword()==null ||
                user.getEmail()==null){
            isValid=true;
        }
        return isValid;
    }


    public static boolean checkForLength(String entity, int minLength,int maxLength){
        if(entity.length()<minLength || entity.length()> maxLength){
            return false;
        }
        return true;
    }
    public static boolean checkForCyrillic(String entity){
        String falseSymbols="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String[] symbols=entity.split("");
        for(String symbol:symbols){
            if(falseSymbols.contains(symbol)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkForNull(String entity){
        if(entity.equals("") || entity.equals(null)){
            return false;
        }
        return true;
    }



}
