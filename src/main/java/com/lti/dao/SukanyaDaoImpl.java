package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.SukanyaAccount;
import com.lti.entity.SukanyaDoc;
@Repository
public class SukanyaDaoImpl implements SukanyaDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	
	public SukanyaAccount register(SukanyaAccount sukanyaAccount) {
		// TODO Auto-generated method stub
		return em.merge(sukanyaAccount);
	}

	@Override
	public SukanyaAccount getSukanyaById(int sukanyaId) {
		return em.find(SukanyaAccount.class, sukanyaId);
	}

	@Override
	@Transactional
	public SukanyaDoc addSukanyaDoc(SukanyaDoc sukanyaDoc) {
		return em.merge(sukanyaDoc);
	}

}
