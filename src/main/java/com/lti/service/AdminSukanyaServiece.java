package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.SukanyaAccount;

@Service
public class AdminSukanyaServiece {

	@Autowired
	private AdminSukanyaRepo repo;
	
	public List<SukanyaAccount> getData(){
		return (List<SukanyaAccount>) repo.findAll();		 
	}
}
