package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.FamilyDetailsDto;
import com.lti.dto.UpdateDocumentDto;
import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserIdDto;
import com.lti.dto.UserLoginDto;
import com.lti.dto.UserPasswordChangeDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;
import com.lti.entity.Document;
import com.lti.entity.Family;
import com.lti.service.DocumentService;
import com.lti.service.UserService;
	
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DocumentService docService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public boolean signup(@RequestBody UserRegisterDto user) {
		return userService.signup(user);
	}
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public UserProfileDto updateProfile(@RequestBody UpdateUserDto user) {
		return userService.updateProfile(user);
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public boolean login(@RequestBody UserLoginDto userLoginDto) {
		return userService.userLogin(userLoginDto.getUserId(), userLoginDto.getPassword());
	}
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.POST)
	public UserProfileDto getProfileDetails(@RequestBody UserIdDto userId) {
		UserProfileDto userProfileDto = userService.getProfileDetails(userId.getUserId());
		userProfileDto.setAccomodationStatus(null);
		userProfileDto.setSukanyaAccount(null);
		userProfileDto.setEnroll(null);
		userProfileDto.getDocument().setUser(null);
//		userProfileDto.set(null);
		return userProfileDto;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public boolean changePassword(@RequestBody UserPasswordChangeDto dto) {
		return userService.changePassword(dto.getUserId(), dto.getPassword(), dto.getNewPassword());
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public boolean resetPassword(@RequestBody UserIdDto userId) {
		return userService.resetPassword(userId.getUserId());
	}
	
	@RequestMapping(value = "/addFamilyMember", method = RequestMethod.POST)
	public Family addFamilyMember(@RequestBody FamilyDetailsDto familyMember) {
		return userService.addOrUpdateFamily(familyMember);
	}
	
	@RequestMapping(value = "/getFamilyDetails", method = RequestMethod.POST)
	public List<Family> getFamilyDetails(@RequestBody UserIdDto userId) {
		return userService.getFamilyDetails(userId.getUserId());
	}
	
	@RequestMapping(value = "/updateAadhaar", method = RequestMethod.POST)
	public Document updateAadhaar(@RequestBody UpdateDocumentDto documentDto) {
		return userService.updateAadhaar(documentDto.getDocumentId(), documentDto.getLink());
	}
	
	@RequestMapping(value = "/updatePan", method = RequestMethod.POST)
	public Document updatePan(@RequestBody UpdateDocumentDto documentDto) {
		return userService.updatePan(documentDto.getDocumentId(), documentDto.getLink());
	}
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
	public String loadFile(@RequestBody String fileName, HttpServletRequest request) {
		return docService.loadFile(fileName, request);
	}

}
