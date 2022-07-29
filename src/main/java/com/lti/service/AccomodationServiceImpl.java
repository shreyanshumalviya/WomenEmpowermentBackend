package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AccomodationDao;
import com.lti.dao.NgoDao;
import com.lti.dto.AccomodationRegistrationDto;
import com.lti.entity.Accomodation;
import com.lti.entity.AccomodationStatus;
import com.lti.entity.Course;
import com.lti.entity.Ngo;

@Service
public class AccomodationServiceImpl implements AccomodationService {

	@Autowired
	NgoDao ngoDao;
	
	@Autowired
	AccomodationDao accomodationDao;
	
	@Override
	public Accomodation createAccomodation(AccomodationRegistrationDto accomodationDto) {

		Accomodation accomodation= accomodationDto.toAccomodation();
		System.out.println(accomodationDto.getNgo_id()+ " shreyanshu");
		Ngo ngo = ngoDao.getNgoById(accomodationDto.getNgo_id());
		System.out.println(ngo.getEmail());
		try {
			accomodation.setNgo(ngo);
		} catch (Exception e) {
			System.out.println("Cant set NGO");
		}
		return accomodationDao.createAccomodation(accomodation);
	}

	@Override
	public List<Accomodation> listAccomodationsByNgoId(int ngoId) {
		return accomodationDao.listAccomodationsByNgoId(ngoId);
	}

	@Override
	public List<AccomodationStatus> listResidentsByAccomodationId(int accomodationId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
