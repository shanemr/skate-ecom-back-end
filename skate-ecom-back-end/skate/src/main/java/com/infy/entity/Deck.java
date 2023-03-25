package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.DeckColor;
import com.infy.dto.DeckDTO;

@Entity
@Table(name = "deck")
public class Deck {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer brandId;
	private String brandName;
	@Enumerated(EnumType.STRING)
	private DeckColor color;
	private Double size;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	
	public Deck() {
		
	}
	
	public Deck(Integer brandId, String brandName, DeckColor color, Double size, Integer quantity,
			Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public static Deck convertToEntity(DeckDTO deckDTO) {
		Deck deck = new Deck();
		deck.setBrandName(deckDTO.getBrandName());
		deck.setColor(deckDTO.getColor());
		deck.setPrice(deckDTO.getPrice());
		deck.setQuantity(deckDTO.getQuantity());
		deck.setSize(deckDTO.getSize());
		deck.setImageUrl(deckDTO.getImageUrl());
		return deck;
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
