package com.infy.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.infy.dto.ProductDTO;
import com.infy.entity.Product;
import com.infy.exception.SkateShopException;


public interface ProductService {
	
	public List<ProductDTO> getAllProducts() throws SkateShopException;
	
	public List<ProductDTO> getProductByCategory(String category) throws SkateShopException;
	
	public List<ProductDTO> getProductByBrandName(String brandName) throws SkateShopException;
	
	public List<String> getProductBrandNames() throws SkateShopException;
	
	public Integer updateProductQuantity(Integer qty) throws SkateShopException;
	
	public Integer addProduct(Product product) throws SkateShopException;
	
	
}
