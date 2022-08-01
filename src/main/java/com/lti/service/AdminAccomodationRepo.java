package com.lti.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Accomodation;

@Repository
public interface AdminAccomodationRepo extends JpaRepository<Accomodation, Integer> {

	@Override
	List<Accomodation> findAll();
}
