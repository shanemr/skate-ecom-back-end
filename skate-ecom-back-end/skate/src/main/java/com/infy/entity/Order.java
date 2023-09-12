package com.infy.entity;

import java.sql.Date;
import java.util.List;

import com.infy.dto.OrderDTO;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@OneToMany(mappedBy="order", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	List<PurchasedItem> purchasedItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_id")
	private UserProfile userProfileDetails;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	private Double price;
	
	private Date date;
	
	public Order() {};
	
	public Order(UserProfile userProfileDetails, Double price, Date date, List<PurchasedItem> purchasedItem, Payment payment) {
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

	public List<PurchasedItem> getPurchasedItem() {
		return purchasedItem;
	}

	public void setPurchasedItem(List<PurchasedItem> purchasedItem) {
		this.purchasedItem = purchasedItem;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public void addPurchaseItems(List<PurchasedItem> purchasedItem) {
		this.purchasedItem = purchasedItem;
		purchasedItem.forEach(item -> item.setOrder(this));
	}
	
	
	
}
