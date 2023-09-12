package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.UserProfileDTO;
import com.infy.entity.UserProfile;
import com.infy.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService{

	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Override
	public String setUserProfileDetails(UserProfile userProfileDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfileDTO getUserProfileDetails(String email) {
		// TODO Auto-generated method stub
		UserProfile userProfileDetails = userProfileRepository.findUserProfileDetailsByEmail(email);
		if(userProfileDetails == null) {
			return new UserProfileDTO();
		}
		
		UserProfileDTO dto = UserProfile.convertToUserProfileDTO(userProfileDetails);
		
		return dto;
	}

}
