package com.infy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	private Integer Id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_id")
	private UserProfile userProfileDetails;
}
