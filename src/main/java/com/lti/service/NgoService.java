package com.lti.service;

import com.lti.dto.NgoLogin;
import com.lti.entity.Ngo;

public interface NgoService {
	Ngo register(Ngo ngo);

	Ngo login(NgoLogin ngoLogin);

	boolean verifyNgo(int ngoId);
}
