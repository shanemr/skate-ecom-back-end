package com.infy.abstractClasses;


import com.infy.entity.UserProfile;



public abstract class Address {
	
	
	private String streetAddress;
	
	private Integer aptStNumber;
	
	private Integer zipCode;
	
	private UserProfile userProfile;

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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
}
