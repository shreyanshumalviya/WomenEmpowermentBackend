package com.lti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.NgoDao;
import com.lti.dao.NgoDaoImpl;
import com.lti.entity.Ngo;

@SpringBootTest
class NgoTest5 {


	@Autowired
	NgoDaoImpl dao;
	
	@Test
	void test() {
		Ngo ngo = new Ngo();
		ngo.setName("ngo name");
		try {
			System.out.println("Shreyanshu "+dao);
		dao.register(ngo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testCourseCounts() {
		System.out.println(dao.getCoursesCount(1002));
		assertEquals(1, 
				dao.getCoursesCount(1002));
	}
	
	

}
