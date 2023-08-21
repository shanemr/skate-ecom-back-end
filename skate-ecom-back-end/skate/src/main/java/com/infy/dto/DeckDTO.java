package com.infy.dto;

public class DeckDTO {
	private String brandId;
	private String brandName;
	private DeckColor color;
	private Double size;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	
	public DeckDTO(String brandId, String brandName, DeckColor color, Double size, Integer quantity,
			Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public DeckDTO() {}
	
	
	
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
	public DeckColor getColor() {
		return color;
	}
	public void setColor(DeckColor color) {
		this.color = color;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
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
