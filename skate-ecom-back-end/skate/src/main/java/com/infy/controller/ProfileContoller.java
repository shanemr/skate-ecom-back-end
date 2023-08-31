package com.infy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.config.JwtUtils;
import com.infy.dto.UserProfileDTO;
import com.infy.entity.UserProfile;
import com.infy.repository.UserProfileRepository;

@RestController
@RequestMapping("/profile")
@CrossOrigin
public class ProfileContoller {
	
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@GetMapping("")
	public ResponseEntity<UserProfileDTO> getProfileDetails(){
		SecurityContext context = SecurityContextHolder.getContext();
		String email = context.getAuthentication().getName();
		UserProfile userProfileDetails = userProfileRepository.findUserProfileDetailsByEmail(email);
		UserProfileDTO dto = UserProfile.convertToUserProfileDTO(userProfileDetails);
		System.out.println("User Profile Details are " + dto);
		return new ResponseEntity<UserProfileDTO>(dto, HttpStatus.ALREADY_REPORTED);
	}

}
