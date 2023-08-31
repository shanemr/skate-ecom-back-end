package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.infy.dto.ProductDTO;

import com.infy.exception.SkateShopException;

import com.infy.service.ProductService;

@RestController()
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	//private PasswordEncoder passwordEncoder;
	
	
	
	@GetMapping("/allBrands")
	public ResponseEntity<String> getAllBrands() throws SkateShopException{
		
	
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> getAllProducts() throws SkateShopException{
		List<ProductDTO> dtos = productService.getAllProducts();
		return new ResponseEntity<List<ProductDTO>>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/all/type")
	public ResponseEntity<List<ProductDTO>> getAllProductsByType(@RequestParam("productType") String productType) throws SkateShopException{
		List<ProductDTO> dtos = productService.getProductByType(productType);
		return new ResponseEntity<List<ProductDTO>>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping("all/brands")
	public ResponseEntity<List<String>> getAllBrandNames() throws SkateShopException{
		List<String> brands = productService.getProductBrandNames();
		return new ResponseEntity<List<String>>(brands, HttpStatus.OK);
	}
	
}