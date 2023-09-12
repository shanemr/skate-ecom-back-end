package com.infy.entity;



import java.util.List;

import com.infy.dto.ProductColor;
import com.infy.dto.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private String category;
	@Column(nullable =false)
	private Double rating;
	@Column(nullable =false)
	private String description;
	private String truckType;
	
	@OneToMany(mappedBy = "product")
	private List<PurchasedItem> purchasedItem;
	
	public Product() {};
	
	public Product(String brandName, Integer quantity, Double price, String imageUrl, String type, String description, Double rating, ProductColor color) {
		this.brandName = brandName;
		this.inStock = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
		this.category = type;
		this.description = description;
		this.rating = rating;
		this.color = color;
	}
	
	public Integer getId() {
		return this.productId;
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
		return category;
	}
	public void setType(String type) {
		this.category = type;
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
	
	public static Product convertToProduct(ProductDTO dto) {
		Product product = new Product();
		product.setBrandName(dto.getBrandName());
		product.setColor(dto.getColor());
		product.setDescription(dto.getDescription());
		product.setImageUrl(dto.getImageUrl());
		product.setPrice(dto.getPrice());
		product.setRating(dto.getRating());
		product.setSize(dto.getSize());
		product.setTruckType(dto.getTruckType());
		product.setType(dto.getType());
		product.setId(dto.getProductId());
		return product;
	}
	
}
