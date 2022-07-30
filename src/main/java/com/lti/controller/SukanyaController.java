package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.SukanyaRegistrationDto;
import com.lti.entity.Ngo;
import com.lti.entity.SukanyaAccount;
import com.lti.service.NgoServiceImpl;
import com.lti.service.SukanyaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sukanya")
public class SukanyaController {

	@Autowired
	SukanyaServiceImpl sukanyaService;
	
	@RequestMapping (value = "/register", method = RequestMethod.POST)
	public SukanyaAccount signup(@RequestBody SukanyaRegistrationDto sukanyaAccount) {
		System.out.println("here");

		return sukanyaService.register(sukanyaAccount.toSukanyaAccount());
	}	
	
}
