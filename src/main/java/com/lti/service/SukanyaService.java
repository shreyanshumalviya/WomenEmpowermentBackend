package com.lti.service;

import com.lti.dto.SukanyaDocRegister;
import com.lti.entity.SukanyaAccount;
import com.lti.entity.SukanyaDoc;

public interface SukanyaService {
	SukanyaAccount register(SukanyaAccount sukanyaAccount, int userId);

	SukanyaDoc postSukanyaDocument(SukanyaDocRegister docRegister);

}
