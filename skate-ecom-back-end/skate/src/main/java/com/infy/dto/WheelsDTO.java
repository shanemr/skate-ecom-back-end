package com.infy.dto;

import com.infy.entity.Wheels;

public class WheelsDTO {
	private String brandId;
	private String brandName;
	private Integer size;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	
	public WheelsDTO(){
		
	}
	
	public WheelsDTO(String brandId, String brandName, Integer size, Integer quantity, Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	
	public static WheelsDTO convertToDTO(Wheels wheels) {
		WheelsDTO wheelsDTO = new WheelsDTO(
				wheels.getBrandId(),
				wheels.getBrandName(),
				wheels.getSize(),
				wheels.getQuantity(),
				wheels.getPrice(),
				wheels.getImageUrl()
				);
		return wheelsDTO;
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
