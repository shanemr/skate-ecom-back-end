package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE category like :category")
	public List<Product> findProductByType(String category);
	
	public List<Product> findProductByBrandName(String brandName);
	
	@Query("SELECT DISTINCT brandName FROM Product")
	public List<String> findAllBrandNames();
	
}
