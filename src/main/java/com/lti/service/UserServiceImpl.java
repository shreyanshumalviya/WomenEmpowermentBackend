package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.UserDao;
import com.lti.dto.FamilyDetailsDto;
import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;
import com.lti.entity.Document;
import com.lti.entity.Family;
import com.lti.entity.User;
import com.lti.exception.UserIdMissingException;
import com.lti.exception.UserNotFoundException;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	EmailService emailService;

	public boolean signup(UserRegisterDto user) {
		try {
			user.getDob().plusDays(1);
			UserProfileDto user2 = userDao.addUser(user);
			try {
				emailService
						.sendEmailForSignup(user.getEmail(),
								"Sign up to Portal successfull\nYour User Id is: " + user2.getUserId()
										+ "\nUse with your registered password to login",
								"Welcome - Signup Successfull");
			} catch (Exception e) {
				System.out.println(e);
			}
			return user2 != null;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public UserProfileDto updateProfile(UpdateUserDto user) {
		try {
			user.getDob().plusDays(1);
			if (user.getUserId() == 0) {
				throw new UserIdMissingException("Please mention your user id");
			} else if (userDao.searchUserById(user.getUserId()) == null) {
				throw new UserNotFoundException("User not found");
			} else {
				return userDao.updateUser(user);
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean userLogin(int userId, String password) {
		return userDao.login(userId, password);
	}

	public UserProfileDto getProfileDetails(int userId) {
		return userDao.searchUserById(userId);
	}

	public boolean changePassword(int userId, String password, String newPassword) {
		return userDao.changePassword(userId, password, newPassword);
	}

	public boolean resetPassword(int userId) {
		return userDao.resetPassword(userId);
	}

	public Family addOrUpdateFamily(FamilyDetailsDto family) {
		family.getDob().plusDays(1);
		Family familyMember = family.toFamily();
		User user = userDao.getUserById(family.getUserId());

		try {
			familyMember.setUser(user);
		} catch (Exception e) {
			System.out.println("Cant set user");
		}
		return userDao.addFamilyOrUpdate(familyMember);
	}

	public List<Family> getFamilyDetails(int userId) {
		return userDao.getFamilyDetails(userId);
	}

	public Document updateAadhaar(int documentId, String link) {
		return userDao.updateAadhaar(documentId, link);
	}

	public Document updatePan(int documentId, String link) {
		return userDao.updatePan(documentId, link);
	}

}
