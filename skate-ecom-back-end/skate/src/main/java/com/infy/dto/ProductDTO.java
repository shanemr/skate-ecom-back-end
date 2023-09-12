package com.infy.dto;

import com.infy.entity.Product;

public class ProductDTO {
	private Integer productId;
	private String brandName;
	private ProductColor color;
	private Double price;
	private Double size;
	private String imageUrl;
	private String category;
	private Double rating;
	private String description;
	private String truckType;
	
	public ProductDTO() {};
	
	public ProductDTO(String brandName, ProductColor color, Double price, String imageUrl, String type,
			Double rating, String description, String truckType, Double size) {
		this.brandName = brandName;
		this.color = color;
		this.price = price;
		this.imageUrl = imageUrl;
		this.category = type;
		this.rating = rating;
		this.description = description;
		this.truckType = truckType;
		this.size = size;
	}
	
	
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setId(Integer id) {
		this.productId = id;
	}

	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public ProductColor getColor() {
		return color;
	}
	public void setColor(ProductColor color) {
		this.color = color;
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
	public String getType() {
		return category;
	}
	public void setType(String type) {
		this.category = type;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}
	
	
	
	public static ProductDTO convertToDTO(Product product) {
		
		ProductDTO dto = new ProductDTO();
		dto.setBrandName(product.getBrandName());
		dto.setColor(product.getColor());
		dto.setDescription(product.getDescription());
		dto.setImageUrl(product.getImageUrl());
		dto.setPrice(product.getPrice());
		dto.setRating(product.getRating());
		dto.setSize(product.getSize());
		dto.setTruckType(product.getTruckType());
		dto.setType(product.getType());
		return dto;
	}

	
	
}
