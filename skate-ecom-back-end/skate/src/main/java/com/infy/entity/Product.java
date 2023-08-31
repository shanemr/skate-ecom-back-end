package com.infy.entity;



import com.infy.dto.ProductColor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	private Integer productId;
	@Column(nullable =false)
	private String brandName;
	@Column(nullable =false)
	private Integer inStock;
	private Double size;
	@Enumerated(EnumType.STRING)
	private ProductColor color;
	@Column(nullable =false)
	private Double price;
	@Column(nullable =false)
	private String imageUrl;
	@Column(unique = true)
	private String type;
	@Column(nullable =false)
	private Double rating;
	@Column(nullable =false)
	private String description;
	private String truckType;
	@OneToOne(mappedBy = "product")
	private PurchasedItem purchasedItem;
	
	public Product() {};
	
	public Product(String brandName, Integer quantity, Double price, String imageUrl, String type, String description, Double rating, ProductColor color) {
		this.brandName = brandName;
		this.inStock = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
		this.type = type;
		this.description = description;
		this.rating = rating;
		this.color = color;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getQuantity() {
		return inStock;
	}
	public void setQuantity(Integer quantity) {
		this.inStock = quantity;
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
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
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
	
	
	public ProductColor getColor() {
		return this.color;
	}
	
	
	public void setColor(ProductColor color) {
		this.color = color;
	}
	
	
	
}
