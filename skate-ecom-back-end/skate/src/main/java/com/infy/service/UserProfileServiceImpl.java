package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.entity.UserProfile;
import com.infy.repository.UserProfileRepository;

public class UserProfileServiceImpl implements UserProfileService{

	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Override
	public String setUserProfileDetails(UserProfile userProfileDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile getUserProfileDetails(String email) {
		// TODO Auto-generated method stub
		UserProfile userProfileDetails = userProfileRepository.findUserProfileDetailsByEmail(email);
		if(userProfileDetails != null) {
			return userProfileDetails;
		}
		return new UserProfile();
	}

}
