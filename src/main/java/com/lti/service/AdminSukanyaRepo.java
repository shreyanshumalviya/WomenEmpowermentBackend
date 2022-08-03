package com.lti.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.SukanyaAccount;

@Repository
public interface AdminSukanyaRepo extends JpaRepository<SukanyaAccount, Integer> {
	
	@Override
	List<SukanyaAccount> findAll();
}
