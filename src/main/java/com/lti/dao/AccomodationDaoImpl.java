package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Accomodation;
import com.lti.entity.AccomodationStatus;
import com.lti.entity.Ngo;

@Repository
public class AccomodationDaoImpl implements AccomodationDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Accomodation createAccomodation(Accomodation accomodation) {
		return em.merge(accomodation);
	}

	@Override
	public List<Accomodation> listAccomodationsByNgoId(int ngoId) {
		return em.find(Ngo.class, ngoId).getAccomodations();
	}

	@Override
	public List<AccomodationStatus> listResidentsByAccomodationId(int accomodationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
