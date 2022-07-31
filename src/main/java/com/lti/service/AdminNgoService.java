package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Ngo;

@Service
public class AdminNgoService {
	@Autowired
	private AdminNgoRepo repo;
	
	public List<Ngo> getData(){
		return (List<Ngo>) repo.findAll();		 
	}
	
	
	public Ngo updateNgo(Ngo ngo) {
		Integer id = ngo.getNgoId();
		Ngo std = repo.findById(id).get();
		std.setVerified(std.isVerified());
		return repo.save(std);
	}
}
