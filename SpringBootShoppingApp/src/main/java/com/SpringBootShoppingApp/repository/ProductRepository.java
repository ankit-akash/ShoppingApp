package com.SpringBootShoppingApp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootShoppingApp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByProductPriceBetween(int initialPrice, int finalPrice);
    public List<Product> findByProductCategory(String productCategory);
    public List<Product> findByProductValidityBefore(Date productValidity);
}
