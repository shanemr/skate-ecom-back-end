package com.infy.entity;

import java.util.List;

import com.infy.dto.UserProfileDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private String email;
	

	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String phoneNum;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfileDetails")
	private List<Order> orders;

	@OneToOne(mappedBy = "userProfileDetails")
	private UserEntity userEntity;
	
	public UserProfile() {}
	
	
	public UserProfile(String email, String firstName, String lastName, String address, String phoneNum
			) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	
public static UserProfileDTO convertToUserProfileDTO(UserProfile entity) {
		UserProfileDTO dto = new UserProfileDTO(entity.getEmail(), entity.getFirstName(), entity.getLastName(), entity.getAddress(), entity.getPhoneNum());
		return dto;
	}
	
}
