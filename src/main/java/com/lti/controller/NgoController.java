package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.NgoLogin;
import com.lti.dto.NgoRegisterDto;
import com.lti.entity.Ngo;
import com.lti.service.NgoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ngo")
public class NgoController {

	@Autowired
	NgoServiceImpl ngoService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {"application/json"})
	public Ngo signup(@RequestBody NgoRegisterDto ngo) {
		System.out.println("here");

		return ngoService.register(ngo.toNgo());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Ngo login(@RequestBody NgoLogin ngoLogin) {
		System.out.println("here2");
		try {
			return ngoService.login(ngoLogin);
		} catch (Exception e) {
			return null;
		}
	}

}
