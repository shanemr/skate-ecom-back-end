package com.infy.dto;


public class PurchasedItemDTO {
	
	private Integer orderId;
	
	private String itemId;
	
	private Integer qty;
	
	public PurchasedItemDTO() {};

	public PurchasedItemDTO(Integer orderId, String itemId, Integer qty) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.qty = qty;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
	

	
	
	
}
