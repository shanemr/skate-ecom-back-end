package com.infy.service;

import com.infy.entity.UserProfile;

public interface UserProfileService {
	
	public String setUserProfileDetails(UserProfile userProfileDetails);
	
	public UserProfile getUserProfileDetails(String email);
}
