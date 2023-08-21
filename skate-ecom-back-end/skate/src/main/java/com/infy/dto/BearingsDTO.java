package com.infy.dto;

import java.text.DecimalFormat;

import com.infy.entity.Bearings;

public class BearingsDTO {
	private String brandId;
	private String brandName;
	private String bearingsType;
	private Integer quantity;
	private Double price;
	private String imageUrl;
	private static DecimalFormat df = new DecimalFormat("##.##");
	
	public BearingsDTO() {}
	
	public BearingsDTO(String brandId, String brandName, String bearingsType, Integer quantity, Double price, String imageUrl) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.bearingsType = bearingsType;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public static BearingsDTO convertToDTO(Bearings bearings) {
		BearingsDTO bearingsDTO = new BearingsDTO(
				bearings.getBrandId(),
				bearings.getBrandName(),
				bearings.getBearingsType(),
				bearings.getQuantity(),
				Double.parseDouble(df.format(bearings.getPrice())),
				bearings.getImageUrl()
				);
		return bearingsDTO;
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

	@Override
	public String toString() {
		return "BearingsDTO [brandId=" + brandId + ", brandName=" + brandName + ", bearingsType=" + bearingsType + ", quantity=" + quantity + ", price="
				+ price + ", image url=" + imageUrl + "]";
	}
	
	
	
	
}
