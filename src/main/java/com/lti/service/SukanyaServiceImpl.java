package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.NgoDao;
import com.lti.dao.SukanyaDao;
import com.lti.entity.SukanyaAccount;
@Service
public class SukanyaServiceImpl implements SukanyaService {
	@Autowired
	SukanyaDao dao;
	@Override
	public SukanyaAccount register(SukanyaAccount sukanyaAccount) {
		// TODO Auto-generated method stub
		return dao.register(sukanyaAccount);
	}

}
