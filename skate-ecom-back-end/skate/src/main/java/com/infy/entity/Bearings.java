package com.infy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.infy.dto.BearingsDTO;

@Entity
@Table(name="bearings")
public class Bearings {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String brandId;
	private String brandName;
	private String bearingsType;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	
	public Bearings() {
		
	}
	
	public Bearings(String brandId, String brandName, String bearingsType, Integer quantity, Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.bearingsType = bearingsType;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public static Bearings convertToEntity(BearingsDTO bearingsDTO) {
		Bearings bearings = new Bearings();
		bearings.setBrandName(bearingsDTO.getBrandName());
		bearings.setBearingsType(bearingsDTO.getBearingsType());
		bearings.setPrice(bearingsDTO.getPrice());
		bearings.setQuantity(bearingsDTO.getQuantity());
		bearings.setImageUrl(bearingsDTO.getImageUrl());
		return bearings;
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
	
	public String getBearingsType() {
		return this.bearingsType;
	}
	
	public void setBearingsType(String bearingsType) {
		this.bearingsType = bearingsType;
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
