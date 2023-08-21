package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.infy.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	
	UserEntity findByEmail(String email);
	
	//UserDetails findUserByEmail(String email);

}
