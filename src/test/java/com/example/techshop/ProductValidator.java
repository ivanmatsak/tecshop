package com.example.techshop;

import com.example.tecshop.model.Product;
import com.example.tecshop.model.User;
import com.example.tecshop.repository.ProductRepository;
import com.example.tecshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductValidator {
    @Autowired
    private static ProductRepository productRepository;

    public static boolean isAddUserValid(String name, String price,
                                         String email, String image, Product updatedProduct){
        if(updatedProduct.getFirstName()==name &&
                updatedProduct.getLastName()==price &&
                updatedProduct.getImageUrl()==image &&
                updatedProduct.getEmailId()==email){
            return true;
        }
        return false;
    }
    public static boolean isUpdateUserValid(String name, String price,
                                            String email, String image, Product updatedProduct){
        if(updatedProduct.getFirstName()==name &&
        updatedProduct.getLastName()==price &&
        updatedProduct.getImageUrl()==image &&
        updatedProduct.getEmailId()==email){
            return false;
        }
        return true;
    }
    public static boolean isDeleteUserValid(Product updatedProduct){
        if(updatedProduct.getFirstName()==null &&
                updatedProduct.getLastName()==null &&
                updatedProduct.getImageUrl()==null &&
                updatedProduct.getEmailId()==null){
            return true;
        }
        return false;
    }
    public static boolean checkForLength(String entity, int minLength,int maxLength){
        if(entity.length()<minLength || entity.length()> maxLength){
            return false;
        }
        return true;
    }
    public static boolean checkForFalseSymbols(String entity){
        String falseSymbols=";,?/$@':=+!`~";
        String[] symbols=entity.split("");
        for(String symbol:symbols){
            if(falseSymbols.contains(symbol)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkForNumbers(String entity){
        boolean answer=true;
        String numSymbols="1234567890";
        String[] symbols=entity.split("");
        for(String symbol:symbols){
            if(!numSymbols.contains(symbol)){
                answer=false;
        }
        }
        return answer;
    }
    public static boolean checkForNull(String entity){
        if(entity.equals("") || entity.equals(null)){
            return false;
        }
        return true;
    }
}
