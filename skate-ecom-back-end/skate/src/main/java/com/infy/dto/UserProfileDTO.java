package com.infy.dto;

import java.util.List;

import com.infy.entity.BillAddress;
import com.infy.entity.Order;
import com.infy.entity.ShipAddress;
import com.infy.entity.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class UserProfileDTO {
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	
	private List<ShipAddressDTO> shipAddress;
	
	
	private List<BillAddressDTO> billAddress;
	
	
	private String phoneNum;
	
	private List<Order> orders;

	private UserEntity userEntity;
	
	public UserProfileDTO() {}
	
	
	public UserProfileDTO(String email, String firstName, String lastName, String phoneNum
			) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public List<ShipAddressDTO> getShipAddress() {
		return shipAddress;
	}


	public void setShipAddress(List<ShipAddressDTO> shipAddress) {
		this.shipAddress = shipAddress;
	}


	public List<BillAddressDTO> getBillAddress() {
		return billAddress;
	}


	public void setBillAddress(List<BillAddressDTO> billAddress) {
		this.billAddress = billAddress;
	}


	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
