package com.infy;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.infy.exception.SkateShopException;

import com.infy.dto.ProductColor;
import com.infy.dto.ProductDTO;
import com.infy.dto.PaymentDTO;
import com.infy.dto.UserProfileDTO;
import com.infy.dto.PurchasedItemDTO;
import com.infy.dto.OrderDTO;

import jakarta.persistence.EntityManager;

import com.infy.service.OrderService;
import com.infy.service.OrderServiceImpl;
import com.infy.service.ProductService;
import com.infy.service.UserProfileService;
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
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SkateApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		testPurchaseOrder();
	}
	
	
	
	
	public  List<ProductDTO> getAllProducts() throws SkateShopException{
		List<ProductDTO> dtos = productService.getAllProducts();
		dtos.forEach(d ->{
			System.out.println("Brand name " + d.getBrandName());
		});
		return dtos;
	}
	
	public void testPurchaseOrder() throws SkateShopException{
		UserProfileDTO userProfileDTO = userProfileService.getUserProfileDetails("admin@admin.com");
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setAmount(545.32);
		paymentDTO.setCard("1234-4564-45632");
		paymentDTO.setUser(userProfileDTO);
		
		
		List<ProductDTO> productDtos = new ArrayList<>();
		productDtos.addAll(getAllProducts());
		List<PurchasedItemDTO> itemsDtos   = new ArrayList<>();
		for(int i = 0; i < 1; i++) {
			PurchasedItemDTO purchasedItemDTO = new PurchasedItemDTO();
			purchasedItemDTO.setProduct(productDtos.get(i));
			purchasedItemDTO.setQty(10);
			itemsDtos.add(purchasedItemDTO);
		}
		
		for(PurchasedItemDTO p: itemsDtos) {
			System.out.println(p.getProduct().getProductId());
		}
			
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setUserProfileDetails(userProfileDTO);
		orderDTO.setPayment(paymentDTO);
		orderDTO.setPrice(545.32);
		orderDTO.setPurchasedItem(itemsDtos);
		orderDTO.setDate(null);
		
		Integer orderNum = orderService.purchase(orderDTO);
		System.out.println("ORDER NUMBER IS " + orderNum);
		
	}
	
	

}
