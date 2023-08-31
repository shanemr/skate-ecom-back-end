package com.infy.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.PurchasedItemDTO;
import com.infy.entity.Order;
import com.infy.entity.UserProfile;
import com.infy.repository.OrderRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	OrderRepository orderRepository;
	
	
	
	@Override
	public Integer purchase(List<PurchasedItemDTO> itemsDTO, Double price, Date date, String email) {
		// TODO Auto-generated method stub
		
		UserProfile userProfile = userProfileService.getUserProfileDetails(email);
		
		//Order order = new Order(itemsDTO, userProfile, price, date);
		
		return null;
	}
	
	
	
	
}
