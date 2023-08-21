package com.infy.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.config.JwtUtils;
import com.infy.repository.UserRepository;
import com.infy.dto.UserDTO;
import com.infy.entity.UserEntity;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private  AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private JwtUtils jwtUtils;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody UserDTO request){
		System.out.println("request Sent");
		authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
				);
		UserEntity userEntity =  userRepository.findByEmail(request.getEmail());
		UserDetails user = new User(
				userEntity.getEmail(),
				userEntity.getPassword(),
				Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
				);
		System.out.println("User details " + user.getUsername() + " " + user.getPassword());
		if(user != null) {
			System.out.println("User not null");
			return new ResponseEntity<String>(jwtUtils.generateToken(user), HttpStatus.OK);
		} 
		
		return new ResponseEntity<String>("Some error has occurred", HttpStatus.BAD_REQUEST);
	}

}
