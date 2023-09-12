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
public class BillAddress extends Address{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String streetAddress;
	
	private Integer aptStNumber;
	
	private Integer zipCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserProfile userProfile;

	
	public BillAddress() {};
	
	
	public BillAddress(String streetAddress, Integer aptStNumber, Integer zipCode, UserProfile userProfile) {
		super();
		this.streetAddress = streetAddress;
		this.aptStNumber = aptStNumber;
		this.zipCode = zipCode;
		this.userProfile = userProfile;
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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
	
}
