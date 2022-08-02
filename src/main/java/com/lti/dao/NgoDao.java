package com.lti.dao;

import com.lti.dto.NgoLogin;
import com.lti.entity.Ngo;
import com.lti.entity.NgoDocuments;

public interface NgoDao {
	Ngo register(Ngo ngo);

	Ngo login(NgoLogin ngoLogin);
	
	Ngo getNgoById(int ngoId);

	long getCoursesCount(int ngoId);
	int getEnrollmentsCount(int ngoId);
	int getAccomodationsCount(int ngoId);
	int getResidentsCount(int ngoId);
	int getDayCareCenterCount(int ngoId);
	int getEnrolledDayCareCenters(int ngoId);

	NgoDocuments registerDoc(NgoDocuments ngoDocuments);
}
