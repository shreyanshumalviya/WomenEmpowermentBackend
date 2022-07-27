package com.lti;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.NgoDao;
import com.lti.entity.Ngo;

public class NgoTest {

	@Autowired
	NgoDao dao;
	@Test
	public void test() {
		Ngo ngo = new Ngo();
		ngo.setNgoName("ngo name");
		dao.register(ngo);
	}

}
