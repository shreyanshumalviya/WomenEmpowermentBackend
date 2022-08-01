package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Accomodation;
import com.lti.entity.Ngo;

@Service
public class AdminAccomodationService {

	@Autowired
	private AdminAccomodationRepo repo;

	public List<Accomodation> getData() {
		return (List<Accomodation>) repo.findAll();
	}

}
