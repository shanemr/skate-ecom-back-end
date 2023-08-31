package com.infy.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infy.entity.UserEntity;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.infy.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws BadCredentialsException {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) {
			System.out.println("User is null");
			throw new UsernameNotFoundException(email);
		}
		UserDetails user = new User(
	 			 userEntity.getEmail(),
	 			 userEntity.getPassword(),
	 			 Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
	 	);
		
		return user; 
		
	}
	
	

}
