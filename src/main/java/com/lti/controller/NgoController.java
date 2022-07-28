package com.lti.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.NgoLogin;
import com.lti.entity.Ngo;
import com.lti.entity.User;
import com.lti.service.NgoService;
import com.lti.service.NgoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ngo")
public class NgoController {

	@Autowired
	NgoServiceImpl ngoService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Ngo signup(@RequestBody Ngo ngo) {
		System.out.println("here");

		return ngoService.register(ngo);
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
