package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AccomodationDao;
import com.lti.dao.NgoDao;
import com.lti.dao.UserDao;
import com.lti.dto.AccomodationRegistrationDto;
import com.lti.entity.Accomodation;
import com.lti.entity.AccomodationStatus;
import com.lti.entity.Course;
import com.lti.entity.Enrollment;
import com.lti.entity.Ngo;
import com.lti.entity.User;

@Service
public class AccomodationServiceImpl implements AccomodationService {

	@Autowired
	NgoDao ngoDao;

	@Autowired
	AccomodationDao accomodationDao;

	@Autowired
	UserDao userDao;
	
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
		List<Accomodation> accomodations=accomodationDao.listAccomodationsByNgoId(ngoId);
		for(Accomodation accomodation: accomodations) {
			accomodation.setAccomodation(null);
		}
		return accomodations;
	}

	@Override
	public List<AccomodationStatus> listResidentsByAccomodationId(int accomodationId) {
		List<AccomodationStatus> accomodationStatii = accomodationDao.listResidentsByAccomodationId(accomodationId);
		for(AccomodationStatus status: accomodationStatii) {
			status.setAccomodation(null);
		}
		return accomodationDao.listResidentsByAccomodationId(accomodationId);
	}

	@Override
	public List<Accomodation> listAllAccomodations() {
		return accomodationDao.listAllAccomodations();
	}

	@Override
	public AccomodationStatus registerForAccomodation(int accomodationId, int userId) {
		// TODO Auto-generated method stub
		AccomodationStatus accomodationStatus=new AccomodationStatus();
		Accomodation accomodation=accomodationDao.getAccomodationById(accomodationId);
		User user=userDao.getUserById(userId);
		accomodationStatus.setUser(user);
		accomodationStatus.setAccomodation(accomodation);
		accomodationStatus.setFromDate(LocalDate.now());
		
		accomodation.setRoomAvailable(accomodation.getRoomAvailable()-1);
		AccomodationStatus accomStatus = accomodationDao.registerForAccomodation(accomodationStatus, accomodation);
		accomStatus.setAccomodation(null);
		return accomStatus;
	}
	
}
