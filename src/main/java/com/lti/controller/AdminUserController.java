package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.User;
import com.lti.service.AdminUserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminuser")
public class AdminUserController {

	@Autowired
	AdminUserService adminUserService;

	@GetMapping("/viewall")
	List<User> getNgo() {
		return adminUserService.getData();
	}
}
