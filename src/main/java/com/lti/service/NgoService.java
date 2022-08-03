package com.lti.service;

import com.lti.dto.NgoDocRegister;
import com.lti.dto.NgoLogin;
import com.lti.dto.NgoStatusDTO;
import com.lti.entity.Ngo;
import com.lti.entity.NgoDocuments;

public interface NgoService {
	Ngo register(Ngo ngo);

	Ngo login(NgoLogin ngoLogin);

	boolean verifyNgo(int ngoId);
	NgoStatusDTO getNgoStatus(int ngoId);
	
	NgoDocuments postNgoDocument(NgoDocRegister docRegister);

	NgoDocuments getNgoDocument(int ngoId);
}
