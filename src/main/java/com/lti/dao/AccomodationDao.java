package com.lti.dao;

import java.util.List;

import com.lti.entity.Accomodation;
import com.lti.entity.AccomodationStatus;

public interface AccomodationDao {
	Accomodation createAccomodation(Accomodation accomodation);
	List<Accomodation> listAccomodationsByNgoId(int ngoId);
	List<AccomodationStatus>listResidentsByAccomodationId(int accomodationId);
}
