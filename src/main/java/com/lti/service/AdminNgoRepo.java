package com.lti.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Ngo;

@Repository
public interface AdminNgoRepo extends JpaRepository<Ngo, Integer> {

//	@Override
//	List<Ngo> findAll();

}
