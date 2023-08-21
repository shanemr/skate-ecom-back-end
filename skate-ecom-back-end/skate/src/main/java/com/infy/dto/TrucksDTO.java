package com.infy.dto;

import com.infy.entity.Trucks;

public class TrucksDTO {
	private String brandId;
	private String brandName;
	private String truckType;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	
	
	public TrucksDTO() {
		
	}
	
	public TrucksDTO(String brandId, String brandName, String truckType, Integer quantity, Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.truckType = truckType;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	
	public static TrucksDTO convertToDTO(Trucks trucks) {
		TrucksDTO trucksDTO = new TrucksDTO();
		trucksDTO.setBrandName(trucks.getBrandName());
		trucksDTO.setBrandId(trucks.getBrandId());
		trucksDTO.setPrice(trucks.getPrice());
		trucksDTO.setTruckType(trucks.getTruckType());
		trucksDTO.setQuantity(trucks.getQuantity());
		trucksDTO.setImageUrl(trucks.getImageUrl());
		return trucksDTO;
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

	@Override
	public String toString() {
		return "TrucksDTO [brandId=" + brandId + ", brandName=" + brandName +   ", truckType = " + truckType +  ", quantity=" + quantity + ", price="
				+ price + ", image url = " + imageUrl + "]";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	
}
