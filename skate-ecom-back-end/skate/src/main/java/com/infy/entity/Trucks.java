package com.infy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.infy.dto.TrucksDTO;

@Entity
public class Trucks {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String brandId;
	private String brandName;
	private String truckType;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	
	public Trucks() {
		
	}
	
	public Trucks(String brandId, String brandName, String truckType, Integer quantity, Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.truckType = truckType;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public static Trucks convertyToEntity(TrucksDTO trucksDTO) {
		Trucks trucks = new Trucks();
		trucks.setBrandName(trucksDTO.getBrandName());
		trucks.setPrice(trucksDTO.getPrice());
		trucks.setQuantity(trucksDTO.getQuantity());
		trucks.setImageUrl(trucksDTO.getImageUrl());
		return trucks;
	}
	
	
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getTruckType() {
		return this.truckType;
	}
	
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
