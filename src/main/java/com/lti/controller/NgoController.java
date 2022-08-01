package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.NgoDocRegister;
import com.lti.dto.NgoLogin;
import com.lti.dto.NgoRegisterDto;
import com.lti.dto.NgoStatusDTO;
import com.lti.entity.Ngo;
import com.lti.entity.NgoDocuments;
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
	public Ngo signup(@RequestBody NgoRegisterDto ngoregisterDto) {
//		System.out.println(ngoregisterDto);
		return ngoService.register(ngoregisterDto.toNgo());
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

	@RequestMapping(value = "/status/{ngoId}", method = RequestMethod.GET)
	public NgoStatusDTO status(@PathVariable int ngoId) {
		return ngoService.getNgoStatus(ngoId);
	}

	@RequestMapping(value = "/upload_doc", method = RequestMethod.POST)
	public NgoDocuments postNgoDocument(@RequestBody NgoDocRegister docRegister) {
		return ngoService.postNgoDocument(docRegister);
	}

}
