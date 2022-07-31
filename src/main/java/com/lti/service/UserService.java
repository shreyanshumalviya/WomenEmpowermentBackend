package com.lti.service;

import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;

public interface UserService {
	boolean signup(UserRegisterDto user);

	UserProfileDto updateProfile(UpdateUserDto user);
	
	boolean userLogin(int userId, String password);
	
	UserProfileDto getProfileDetails(int userId);

	boolean changePassword(int userId, String password, String newPassword);

	boolean resetPassword(int userId);
}
