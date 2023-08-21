package com.infy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.infy.dto.UserDTO;

@Entity
@Table(name="users")
@EnableAutoConfiguration
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	
	@Column(name="email", nullable = false, length = 45)
	private String email;
	
	@Column(name="password", nullable = false, length = 15)
	private String password;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email_id")
	private UserProfile userProfileDetails;
	
	public UserEntity() {};
	
	public UserEntity(Integer userId, String email, String password) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		
	}
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	public static UserDTO convertToDTO(UserEntity user) {
		UserDTO dto = new UserDTO(user.getUserId(),
						user.getEmail(), user.getPassword());
		return dto;
	}
	
	

}
