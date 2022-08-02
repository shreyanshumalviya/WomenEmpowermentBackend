package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Accomodation;
import com.lti.entity.AccomodationStatus;
import com.lti.entity.Course;
import com.lti.entity.Ngo;
import com.lti.entity.User;

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
		return em.find(Ngo.class, ngoId).getAccomodation();
	}

	@Override
	public List<AccomodationStatus> listResidentsByAccomodationId(int accomodationId) {
		Accomodation accomodation = em.find(Accomodation.class, accomodationId);
		if (accomodation == null)
			return null;
		
		return accomodation.getAccomodation();
	}

	@Override
	public List<Accomodation> listAllAccomodations() {
		String jpql = "select a from Accomodation a where a.roomAvailable>0";
		TypedQuery<Accomodation> query = em.createQuery(jpql, Accomodation.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public AccomodationStatus registerForAccomodation(AccomodationStatus accomodationStatus, Accomodation accomodation) {
		em.merge(accomodation);
		AccomodationStatus accStatus = em.merge(accomodationStatus);
		return accStatus;
	}

	@Override
	public Accomodation getAccomodationById(int accomodationId) {
		return em.find(Accomodation.class, accomodationId);
	}

	@Override
	public User getNgoById(int ngoId) {
		return em.find(User.class, ngoId);
	}

}
