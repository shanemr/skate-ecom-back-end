package com.infy.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.OrderDTO;
import com.infy.dto.PaymentDTO;
import com.infy.dto.PurchasedItemDTO;
import com.infy.entity.Order;
import com.infy.entity.Payment;
import com.infy.entity.Product;
import com.infy.entity.UserProfile;
import com.infy.entity.PurchasedItem;
import com.infy.repository.OrderRepository;


import jakarta.transaction.Transactional;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	OrderRepository orderRepository;
	
	
	
	@Override
	public Integer purchase(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setDate(Date.valueOf(LocalDate.now()));
		order.addPurchaseItems(convertToItems(orderDTO.getPurchasedItem()));
		order.setPayment(convertToPayment(orderDTO.getPayment()));
		order.setPrice(orderDTO.getPrice());
		order.setUserProfileDetails(UserProfile.convertToUserProfile(orderDTO.getUserProfileDetails()));
		
		System.out.println("CREATED ORDER"
				+ order.getPurchasedItem() + " " + order.getPayment().getId() + " " + order.getUserProfileDetails());
		
		Integer orderNum = orderRepository.save(order).getId();
		
		return orderNum;
	}
	
	
	
	
	public List<PurchasedItem> convertToItems(List<PurchasedItemDTO> dtos){
		return dtos.stream()
				.map((itemDto) ->{
					PurchasedItem item = new PurchasedItem();
					item.setQty(itemDto.getQty());
					item.setProduct(Product.convertToProduct(itemDto.getProduct()));
					return item;
				}).collect(Collectors.toList());
	}
	
	public Payment convertToPayment(PaymentDTO dto) {
		Payment payment = new Payment();
		payment.setAmount(dto.getAmount());
		payment.setCard(dto.getCard());
		payment.setPaymentDate(Date.valueOf(LocalDate.now()));
		payment.setUser(UserProfile.convertToUserProfile(dto.getUser()));
		return payment;
	}
	
	
	
}
