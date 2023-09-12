package com.infy.dto;

import java.sql.Date;

import com.infy.entity.Order;
import com.infy.entity.UserProfile;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class PaymentDTO {
	
	private String card;
	

	private Date paymentDate;
	

	private Double amount;
	
	private UserProfileDTO user;
	

	public PaymentDTO() {}
	
	
	public PaymentDTO(String card, Date paymentDate, Double amount) {
		super();
		this.card = card;
		this.paymentDate = paymentDate;
		this.amount = amount;

	}



	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public UserProfileDTO getUser() {
		return user;
	}


	public void setUser(UserProfileDTO user) {
		this.user = user;
	}

	
}
