package com.infy.controller;

import java.util.List;

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
import com.infy.dto.ShipAddressDTO;
import com.infy.dto.UserProfileDTO;
import com.infy.entity.ShipAddress;
import com.infy.entity.UserProfile;
import com.infy.exception.SkateShopException;
import com.infy.repository.ShipAddressRepository;
import com.infy.repository.UserProfileRepository;
import com.infy.service.ShipAddressService;

@RestController
@RequestMapping("/profile")
@CrossOrigin
public class ProfileContoller {
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	ShipAddressService shipAddService;
	
	@GetMapping("")
	public ResponseEntity<UserProfileDTO> getProfileDetails() throws SkateShopException{
		System.out.println("Inside Profeil API");
		SecurityContext context = SecurityContextHolder.getContext();
		String email = context.getAuthentication().getName();
		UserProfile userProfileDetails = userProfileRepository.findUserProfileDetailsByEmail(email);
		UserProfileDTO dto = UserProfile.convertToUserProfileDTO(userProfileDetails);
		List<ShipAddressDTO> shipAddress = shipAddService.getShippingAddress(dto.getEmail());
		dto.setShipAddress(shipAddress);
		
		System.out.println("User Profile Details are " + dto);
		return new ResponseEntity<UserProfileDTO>(dto, HttpStatus.ALREADY_REPORTED);
	}

}
