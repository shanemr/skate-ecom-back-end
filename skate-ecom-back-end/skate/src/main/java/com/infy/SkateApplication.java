package com.infy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.infy.exception.SkateShopException;

import com.infy.dto.ProductColor;
import com.infy.dto.ProductDTO;

import jakarta.persistence.EntityManager;

import com.infy.service.OrderServiceImpl;
import com.infy.service.ProductService;
import com.infy.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@SpringBootApplication
public class SkateApplication implements CommandLineRunner{
	
	@Autowired
	ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(SkateApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		getAllProducts();
	}
	
	
	
	
	public  void getAllProducts() throws SkateShopException{
		List<ProductDTO> dtos = productService.getAllProducts();
		dtos.forEach(d ->{
			System.out.println("Brand name " + d.getBrandName());
		});
		
	}
	
	
	
	

}
