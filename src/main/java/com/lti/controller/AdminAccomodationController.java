package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Accomodation;
import com.lti.service.AdminAccomodationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminaccomodation")
public class AdminAccomodationController {

	@Autowired
	AdminAccomodationService adminAccomodationService;

	@GetMapping("/viewall")
	List<Accomodation> getNgo() {
		return adminAccomodationService.getData();
	}
}
