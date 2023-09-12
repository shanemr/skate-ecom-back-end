package com.infy.dto;

import java.sql.Date;
import java.util.List;

import com.infy.entity.Payment;
import com.infy.entity.PurchasedItem;
import com.infy.entity.UserProfile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class OrderDTO {
	
	List<PurchasedItemDTO> purchasedItem;
	
	private UserProfileDTO userProfileDetails;
	
	private PaymentDTO payment;
	
	private Double price;
	
	private Date date;
	
	
	public OrderDTO() {};

	public OrderDTO(UserProfileDTO userProfileDetails, Double price, Date date, List<PurchasedItemDTO> purchasedItem, PaymentDTO payment) {
		this.price = price;
		this.userProfileDetails = userProfileDetails;
		this.date = date;
		this.purchasedItem = purchasedItem;
		this.payment = payment;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	public UserProfileDTO getUserProfileDetails() {
		return userProfileDetails;
	}

	public void setUserProfileDetails(UserProfileDTO userProfileDetails) {
		this.userProfileDetails = userProfileDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<PurchasedItemDTO> getPurchasedItem() {
		return purchasedItem;
	}

	public void setPurchasedItem(List<PurchasedItemDTO> purchasedItem) {
		this.purchasedItem = purchasedItem;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}
	
	
}
