package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccomodationRegistrationDto;
import com.lti.dto.CourseRegisterDTO;
import com.lti.entity.Accomodation;
import com.lti.entity.Course;
import com.lti.service.AccomodationService;
import com.lti.service.AccomodationServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/accomodation")
public class AccomodationController {
	@Autowired
	AccomodationServiceImpl accomodationService;
	

	@RequestMapping (value = "/register", method = RequestMethod.POST)
	public Accomodation signup(@RequestBody AccomodationRegistrationDto accomodation) {
		System.out.println("here");

		return accomodationService.createAccomodation(accomodation);
	}	

	@RequestMapping (value = "/list-accomodations-of-ngo/{ngoId}", method = RequestMethod.GET)
	public List<Accomodation> getAccomodationsByNgoId(@PathVariable int ngoId) {
		System.out.println("here");

		return accomodationService.listAccomodationsByNgoId(ngoId);
	}	
}
