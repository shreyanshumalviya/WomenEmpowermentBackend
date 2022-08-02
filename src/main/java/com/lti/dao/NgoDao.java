package com.lti.dao;

import com.lti.dto.NgoLogin;
import com.lti.entity.Ngo;

public interface NgoDao {
	Ngo register(Ngo ngo);

	Ngo login(NgoLogin ngoLogin);
	
	Ngo getNgoById(int ngoId);

	boolean verifyNgo(int ngoId);
}
