package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.User;

@Service
public class AdminUserService {

	@Autowired
	private AdminUserRepo repo;
	
	public List<User> getData(){
		return (List<User>) repo.findAll();		 
	}
}
