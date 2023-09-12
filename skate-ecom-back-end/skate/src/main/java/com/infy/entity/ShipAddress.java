package com.infy.entity;

import com.infy.abstractClasses.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShipAddress  extends Address{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String streetAddress;
	
	private Integer aptStNumber;
	
	private String city;
	
	private String state;
	
	private Integer zipCode;
	
	private Boolean preferredAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserProfile userProfile;

	
	
	public ShipAddress() {};
	
	
	
	public ShipAddress(String streetAddress, Integer aptStNumber, String city, String state, Integer zipCode, Boolean preferredAddress,
			UserProfile userProfile) {
		super();
		this.streetAddress = streetAddress;
		this.aptStNumber = aptStNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.preferredAddress = preferredAddress;
		this.userProfile = userProfile;
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



	public Integer getId() {
		return id;
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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
}
