package com.lti.dao;

import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;

public interface UserDao {
	UserProfileDto addUser(UserRegisterDto user);
	UserProfileDto updateUser(UpdateUserDto user);
	UserProfileDto searchUserById(int userId);
	boolean login(int userId, String password);
	boolean changePassword(int userId, String password, String newPassword);
	boolean resetPassword(int userId);
}
