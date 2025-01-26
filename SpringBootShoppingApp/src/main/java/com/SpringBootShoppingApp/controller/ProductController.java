package com.SpringBootShoppingApp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootShoppingApp.entity.Product;
import com.SpringBootShoppingApp.exceptions.ProductNotFound;
import com.SpringBootShoppingApp.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/save") // https:localhost:8080/products/save
    public String saveProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/update") // https:localhost:8080/products/update
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @PostMapping("/delete/{id}") // https:localhost:8080/products/delete/123
    public String deleteProduct(@PathVariable("id") int productId) {
        return service.deleteProduct(productId);
    }

    @GetMapping("/getById/{id}") // https:localhost:8080/products/getById/123
    public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound {
        return service.getProductById(productId);
    }

    @GetMapping("/getAll") // https:localhost:8080/products/getAll
    public List<Product> getAllProducts() {
        return service.getAllProduct();
    }

    @GetMapping("/getBetween/{price1}/{price2}") // https:localhost:8080/products/getBetween/1000/2000
    public List<Product> getAllBetween(@PathVariable("price1") int initialPrice, @PathVariable("price2") int finalPrice) {
        return service.findByProductPriceBetween(initialPrice, finalPrice);
    }

    @GetMapping("/getCategory/{productCategory}") // https:localhost:8080/products/getCategory/Shirt
    public List<Product> getAllProductByCategory(@PathVariable("productCategory") String productCategory) {
        return service.findByProductCategory(productCategory);
    }

    @GetMapping("/getValidity/{productValidity}") // https:localhost:8080/products/getValidity/22-12-2025
    public List<Product> getAllProductByDate(@PathVariable("productValidity") @DateTimeFormat(pattern = "dd-MM-yyyy") Date productValidity) {
        return service.findByProductValidityBefore(productValidity);
    }
}
