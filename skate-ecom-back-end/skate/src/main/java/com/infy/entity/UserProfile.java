package com.infy.entity;

import java.util.List;

import com.infy.dto.PaymentDTO;
import com.infy.dto.UserProfileDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_profile_details")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy="userProfile", cascade = CascadeType.ALL)
	private List<ShipAddress> shipAddress;
	
	@OneToMany(mappedBy="userProfile", cascade = CascadeType.ALL)
	private List<BillAddress> billAddress;
	
	
	private String phoneNum;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfileDetails")
	private List<Order> orders;

	@OneToOne(mappedBy = "userProfileDetails")
	private UserEntity userEntity;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Payment> payment;
	
	public UserProfile() {}
	
	
	public UserProfile(String email, String firstName, String lastName, String phoneNum
			) {
		super();
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
	public List<ShipAddress> getShipAddress() {
		return shipAddress;
	}


	public void setShipAddress(List<ShipAddress> shipAddress) {
		this.shipAddress = shipAddress;
	}


	public List<BillAddress> getBillAddress() {
		return billAddress;
	}


	public void setBillAddress(List<BillAddress> billAddress) {
		this.billAddress = billAddress;
	}


	
	
public static UserProfileDTO convertToUserProfileDTO(UserProfile entity) {
		UserProfileDTO dto = new UserProfileDTO(entity.getEmail(), entity.getFirstName(), entity.getLastName(),entity.getPhoneNum());
		return dto;
	}

public static UserProfile convertToUserProfile(UserProfileDTO dto) {
	UserProfile entity = new UserProfile(dto.getEmail(), dto.getFirstName(), dto.getLastName(),dto.getPhoneNum());
	return entity;
}
	
}
