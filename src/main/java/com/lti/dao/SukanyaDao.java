package com.lti.dao;

import com.lti.entity.SukanyaAccount;
import com.lti.entity.SukanyaDoc;

public interface SukanyaDao {
	SukanyaAccount register(SukanyaAccount sukanyaAccount);
	SukanyaAccount getSukanyaById(int sukanyaId);
	SukanyaDoc addSukanyaDoc(SukanyaDoc sukanyaDoc);
}
