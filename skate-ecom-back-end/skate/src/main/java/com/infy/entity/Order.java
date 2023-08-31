package com.infy.entity;

import java.sql.Date;
import java.util.List;

import com.infy.dto.PurchasedItemDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@OneToMany(mappedBy="order", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	List<PurchasedItem> purchasedItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_id")
	private UserProfile userProfileDetails;
	
	private Double price;
	
	private Date date;
	

	public Order(UserProfile userProfileDetails, Double price, Date date, List<PurchasedItem> purchasedItem) {
		this.price = price;
		this.userProfileDetails = userProfileDetails;
		this.date = date;
		this.purchasedItem = purchasedItem;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	public UserProfile getUserProfileDetails() {
		return userProfileDetails;
	}

	public void setUserProfileDetails(UserProfile userProfileDetails) {
		this.userProfileDetails = userProfileDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	
	
	
	
}
