package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dto.NgoLogin;
import com.lti.entity.Ngo;
import com.lti.entity.NgoDocuments;

@Repository
public class NgoDaoImpl implements NgoDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Ngo register(Ngo ngo) {
		Ngo registeredNgo = em.merge(ngo);
		return registeredNgo;
	}

	@Override
	public Ngo login(NgoLogin ngoLogin) {
		String jpql="select ngo from Ngo ngo where ngo.email=:eml and ngo.password=:pwd";
		TypedQuery<Ngo> query = em.createQuery(jpql,Ngo.class);
		query.setParameter("eml", ngoLogin.getEmail());
		query.setParameter("pwd", ngoLogin.getPassword());
		return query.getSingleResult();
	}

	public Ngo getNgoById(int ngoId) {
		return em.find(Ngo.class, ngoId);
	}

	@Override
	public long getCoursesCount(int ngoId) {
		String jpql= "select count(c) from Course c where c.ngo=:ngoId" ;
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("ngoId", ngoId);
		return query.getSingleResult();
	}

	@Override
	public int getEnrollmentsCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAccomodationsCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResidentsCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDayCareCenterCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnrolledDayCareCenters(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public NgoDocuments registerDoc(NgoDocuments ngoDocuments) {
		
		return em.merge(ngoDocuments);
	}
}
