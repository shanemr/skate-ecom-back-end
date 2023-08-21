package com.infy.service;

import java.util.List;

import com.infy.dto.UserDTO;
import com.infy.entity.UserEntity;

public interface UserService {

	public Integer registerUser(UserDTO userDTO);
	
	public UserEntity findUserByEmail(String email);
	
	public List<UserDTO> findAllUsers();
		
	
}
