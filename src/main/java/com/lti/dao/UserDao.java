package com.lti.dao;

import java.util.List;

import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;
import com.lti.entity.Document;
import com.lti.entity.Family;
import com.lti.entity.User;

public interface UserDao {
	UserProfileDto addUser(UserRegisterDto user);

	UserProfileDto updateUser(UpdateUserDto user);

	Family addFamilyOrUpdate(Family familyMember);

	UserProfileDto searchUserById(int userId);

	boolean login(int userId, String password);

	boolean changePassword(int userId, String password, String newPassword);

	boolean resetPassword(int userId);
	boolean verifyUser(int userId);

	List<Family> getFamilyDetails(int userId);

	User getUserById(int userId);
	
	Document updateAadhaar(int documentId, String link);
	
	Document updatePan(int documentId, String link);
}
