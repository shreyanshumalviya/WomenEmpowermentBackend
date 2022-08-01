package com.lti.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.dto.NgoRegisterDto;
import com.lti.entity.Ngo;
import com.lti.entity.SukanyaAccount;

@Repository
public interface AdminRepo extends JpaRepository<Ngo, Integer> {

	

}
