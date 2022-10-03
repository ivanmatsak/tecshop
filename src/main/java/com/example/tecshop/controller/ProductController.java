package com.example.tecshop.controller;

import com.example.tecshop.exception.ResourceNotFoundException;
import com.example.tecshop.model.Product;
import com.example.tecshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/products")

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("product with id"+id+" did not exist"));
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee with id"+id+" did not exist"));
        product.setFirstName(productDetails.getFirstName());
        product.setLastName(productDetails.getLastName());
        product.setEmailId(productDetails.getEmailId());
        product.setImageUrl(productDetails.getImageUrl());



        Product updatedProduct=productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable long id){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("product with id"+id+" did not exist"));
        productRepository.delete(product);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
