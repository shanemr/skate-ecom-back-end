package com.infy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infy.dto.UserDTO;
import com.infy.entity.Role;
import com.infy.entity.UserEntity;
import com.infy.repository.RoleRepository;
import com.infy.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public Integer registerUser(UserDTO userDTO) {
		UserEntity user = new UserEntity();
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		
		Role role = roleRepository.findByName("ROLE_USER");
		if(role == null) {
			role = checkRoleExist();
		}
		
		user.setRole(role);
		
		return userRepository.save(user).getUserId();
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> users = userRepository.findAll();
		return users.stream().map(u ->{
			UserDTO userDTO = UserEntity.convertToDTO(u);
			return userDTO;
		}).collect(Collectors.toList());
	}
	
	
	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

}
