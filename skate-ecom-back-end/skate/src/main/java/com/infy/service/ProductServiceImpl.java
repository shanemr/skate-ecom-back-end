package com.infy.service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.ProductDTO;
import com.infy.entity.Product;
import com.infy.exception.SkateShopException;
import com.infy.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		
		products.forEach(p ->{
			ProductDTO dto = ProductDTO.convertToDTO(p);
			dtos.add(dto);
		});
		return dtos;
	}

	@Override
	public List<ProductDTO> getProductByType(String type) throws SkateShopException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findProductByType(type);
		if(products.isEmpty()) {
			throw new SkateShopException("No prodcuts of type " + type + " found");
		}
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
				
		products.forEach(p ->{
			ProductDTO dto = ProductDTO.convertToDTO(p);
			dtos.add(dto);
		});
		return dtos;
	}

	@Override
	public List<ProductDTO> getProductByBrandName(String brandName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateProductQuantity(Integer qty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProductBrandNames() {
		// TODO Auto-generated method stub
		List<String> brands = productRepository.findAllBrandNames();
		return brands;
	}

}
