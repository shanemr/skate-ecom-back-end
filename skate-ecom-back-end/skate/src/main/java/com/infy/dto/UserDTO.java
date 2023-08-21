package com.infy.dto;

import com.infy.entity.Role;
import com.infy.entity.UserEntity;

public class UserDTO {
	
	private Integer userId;
	
	private String email;
	
	private String password;
	
	private Role role;
	
	
	
	public UserDTO(Integer userId,String email, String password) {
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
	
	public static UserEntity convertToEntity(UserDTO dto) {
		UserEntity user = new UserEntity(dto.getUserId(), 
						dto.getEmail(), dto.getPassword());
		return user;
	}
	
	
	

}
