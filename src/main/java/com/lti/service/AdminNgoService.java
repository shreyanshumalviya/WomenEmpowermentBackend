package com.lti.service;

import com.lti.dto.NgoRegisterDto;
import com.lti.entity.Ngo;

public interface AdminNgoService {
	NgoRegisterDto updateNgo(NgoRegisterDto dto, Integer ngoId);
}
