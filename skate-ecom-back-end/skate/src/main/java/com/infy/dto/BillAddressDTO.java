package com.infy.dto;



public class BillAddressDTO {
	private String streetAddress;
	
	private Integer aptStNumber;
	
	private Integer zipCode;
	
	
	public BillAddressDTO() {};
	
	
	public BillAddressDTO(String streetAddress, Integer aptStNumber, Integer zipCode) {
		super();
		this.streetAddress = streetAddress;
		this.aptStNumber = aptStNumber;
		this.zipCode = zipCode;
	}


	
	
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Integer getAptStNumber() {
		return aptStNumber;
	}

	public void setAptStNumber(Integer aptStNumber) {
		this.aptStNumber = aptStNumber;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	
}
