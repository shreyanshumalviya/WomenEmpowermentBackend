package com.lti.service;

import java.util.List;

import com.lti.dto.AccomodationRegistrationDto;
import com.lti.entity.Accomodation;
import com.lti.entity.AccomodationStatus;
import com.lti.entity.Course;

public interface AccomodationService {

	Accomodation createAccomodation(AccomodationRegistrationDto accomodation);
	List<Accomodation> listAccomodationsByNgoId(int ngoId);
	List<AccomodationStatus>listResidentsByAccomodationId(int accomodationId);
	List<Accomodation> listAllAccomodations();
	AccomodationStatus registerForAccomodation(int accomodationId,int userId);
}
