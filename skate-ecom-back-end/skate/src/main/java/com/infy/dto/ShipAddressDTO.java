package com.infy.dto;



public class ShipAddressDTO {
	
	private String streetAddress;
	
	private Integer aptStNumber;
	
	private String city;
	
	private String state;
	
	private Integer zipCode;
	
	private Boolean preferredAddress;
	

	public ShipAddressDTO() {};
	
	
	
	public ShipAddressDTO(String streetAddress, Integer aptStNumber, String city, String state, Integer zipCode, Boolean preferredAddress) {
		super();
		this.streetAddress = streetAddress;
		this.aptStNumber = aptStNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.preferredAddress = preferredAddress;
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

	public Boolean getPreferredAddress() {
		return preferredAddress;
	}

	public void setPreferredAddress(Boolean preferredAddress) {
		this.preferredAddress = preferredAddress;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	
}
