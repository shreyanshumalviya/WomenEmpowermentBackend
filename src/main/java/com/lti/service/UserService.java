package com.lti.service;

import java.util.List;

import com.lti.dto.FamilyDetailsDto;
import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;
import com.lti.entity.Document;
import com.lti.entity.Family;

public interface UserService {
	boolean signup(UserRegisterDto user);

	UserProfileDto updateProfile(UpdateUserDto user);

	boolean userLogin(int userId, String password);

	UserProfileDto getProfileDetails(int userId);

	boolean changePassword(int userId, String password, String newPassword);

	boolean resetPassword(int userId);

	List<Family> getFamilyDetails(int userId);

	Family addOrUpdateFamily(FamilyDetailsDto family);
	
	Document updateAadhaar(int documentId, String link);
	
	Document updatePan(int documentId, String link);
}
