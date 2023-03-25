package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.WheelsDTO;

@Entity
@Table(name="wheels")
public class Wheels {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer brandId;
	private String brandName;
	private Integer size;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	
	public Wheels() {
		
	}
	
	public Wheels(Integer brandId, String brandName, Integer size, Integer quantity, Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public static Wheels convertToEntity(WheelsDTO wheelsDTO) {
		Wheels wheels = new Wheels();
		wheels.setBrandName(wheelsDTO.getBrandName());
		wheels.setPrice(wheelsDTO.getPrice());
		wheels.setQuantity(wheelsDTO.getQuantity());
		wheels.setSize(wheelsDTO.getSize());
		wheels.setImageUrl(wheelsDTO.getImageUrl());
		return wheels;
	}
	
	
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
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
