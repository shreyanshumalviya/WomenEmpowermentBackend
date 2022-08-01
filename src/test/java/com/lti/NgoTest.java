package com.lti;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.NgoDao;
import com.lti.entity.Ngo;
@SpringBootTest
public class NgoTest {


	@Autowired
	NgoDao dao;
	@org.junit.jupiter.api.Test
	public void test() {
		Ngo ngo = new Ngo();
		ngo.setName("ngo name");
		dao.register(ngo);
	}

}
