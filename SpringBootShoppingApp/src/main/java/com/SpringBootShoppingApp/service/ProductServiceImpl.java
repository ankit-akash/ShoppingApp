package com.SpringBootShoppingApp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SpringBootShoppingApp.entity.Product;
import com.SpringBootShoppingApp.exceptions.ProductNotFound;
import com.SpringBootShoppingApp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	public ProductServiceImpl(ProductRepository repository) {
		super();
		this.repository = repository;
	}

	ProductRepository repository;

	@Override
	public String addProduct(Product product) {
		Product product1 = repository.save(product);
		if (product1 != null) {
			return "Product saved successfully";
		} else {
			return "Failed to Save Product";
		}
	}

	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public String deleteProduct(int productId) {
		repository.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {
		Optional<Product> optional = repository.findById(productId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("No Product Found");
	}

	@Override
	public List<Product> getAllProduct() {

		return repository.findAll();
	}

	@Override
	public List<Product> findByProductPriceBetween(int initialPrice, int finalPrice) {

		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> findByProductCategory(String productCategory) {

		return repository.findByProductCategory(productCategory);
	}

	@Override
	public List<Product> findByProductValidityBefore(Date productValidity) {
	    return repository.findByProductValidityBefore(productValidity);
	}

}
