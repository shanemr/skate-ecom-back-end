package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.infy.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,String>{
	UserProfile findUserProfileDetailsByEmail(String email);
}
