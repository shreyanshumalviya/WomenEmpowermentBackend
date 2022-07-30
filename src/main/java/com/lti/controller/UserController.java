package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UpdateUserDto;
import com.lti.dto.UserIdDto;
import com.lti.dto.UserLoginDto;
import com.lti.dto.UserPasswordChangeDto;
import com.lti.dto.UserProfileDto;
import com.lti.dto.UserRegisterDto;
import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
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
		return userService.getProfileDetails(userId.getUserId());
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public boolean changePassword(@RequestBody UserPasswordChangeDto dto) {
		return userService.changePassword(dto.getUserId(), dto.getPassword(), dto.getNewPassword());
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public boolean resetPassword(@RequestBody UserIdDto userId) {
		return userService.resetPassword(userId.getUserId());
	}

}
