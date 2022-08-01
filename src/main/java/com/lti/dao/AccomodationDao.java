package com.lti.dao;

import java.util.List;

import com.lti.entity.Accomodation;
import com.lti.entity.AccomodationStatus;
import com.lti.entity.Course;
import com.lti.entity.Enrollment;
import com.lti.entity.User;

public interface AccomodationDao {
	Accomodation createAccomodation(Accomodation accomodation);
	List<Accomodation> listAccomodationsByNgoId(int ngoId);
	List<AccomodationStatus>listResidentsByAccomodationId(int accomodationId);
	List<Accomodation> listAllAccomodations();
	AccomodationStatus registerForAccomodation(AccomodationStatus accomodation, Accomodation accomodation2);
	public Accomodation getAccomodationById(int accomodationId);
	public User getNgoById(int ngoId);
}
