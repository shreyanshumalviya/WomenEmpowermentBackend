package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.NgoDao;
import com.lti.dto.NgoLogin;
import com.lti.entity.Ngo;

@Service
public class NgoServiceImpl implements NgoService {

	@Autowired
	NgoDao dao;

	@Override
	public Ngo register(Ngo ngo) {
		System.out.println("Shreyanshu " + dao);
		return dao.register(ngo);
	}

	@Override
	public Ngo login(NgoLogin ngoLogin) {
		return dao.login(ngoLogin);
	}

	public boolean verifyNgo(int ngoId) {
		return dao.verifyNgo(ngoId);
	}
}
