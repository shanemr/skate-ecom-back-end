package com.infy.dto;

import com.infy.entity.Product;

public class PurchasedItemDTO {
	
	private Integer orderId;
	
	private ProductDTO product;
	
	private Integer qty;
	
	public PurchasedItemDTO() {};

	public PurchasedItemDTO(ProductDTO product, Integer qty) {
		super();
		this.product = product;
		this.qty = qty;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
	

	
	
	
}
