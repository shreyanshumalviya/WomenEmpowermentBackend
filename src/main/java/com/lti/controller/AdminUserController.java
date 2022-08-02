package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.NgoRegisterDto;
import com.lti.dto.UserProfileDto;
import com.lti.entity.User;
import com.lti.service.AdminUserServiceImpl;
import com.lti.service.DocumentService;
import com.lti.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/adminuser")
public class AdminUserController {

	@Autowired
	private AdminUserServiceImpl adminUserService;

	@Autowired
	DocumentService docService;
	
	@Autowired
	UserService userService;

	@GetMapping("/viewall")
	List<User> getUser() {
		return adminUserService.getData();
	}

	@PutMapping("/verify/{userId}")
	public boolean verifyUser(@PathVariable int userId) {
		return userService.verifyUser(userId);
	}

	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
	public String loadFile(@RequestBody String fileName, HttpServletRequest request) {
		return docService.loadFile(fileName, request);
	}

}
