package com.infy.service;

import com.infy.dto.UserProfileDTO;
import com.infy.entity.UserProfile;

public interface UserProfileService {
	
	public String setUserProfileDetails(UserProfile userProfileDetails);
	
	public UserProfileDTO getUserProfileDetails(String email);
}
