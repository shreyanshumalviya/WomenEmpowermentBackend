package com.lti.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.UserDao;
import com.lti.dto.UserProfileDto;
import com.lti.entity.Gender;
import com.lti.entity.JobStatus;
import com.lti.entity.MaritalStatus;
import com.lti.entity.ResidenceArea;
import com.lti.entity.User;

class UserTest {
	@Autowired
	UserDao dao;

	@Test
	void addOrUpdateUserTest() {
		User user = new User();
		user.setFirstName("J");
		user.setMiddleName(" ");
		user.setLastName("A");
		user.setEmail("j@a.com");
		user.setPassword("pass");
		user.setContactNo("0987654321");
		user.setAadhaarNo("123412341234");
		user.setPanNo("XXXXX0000X");
		user.setDob(LocalDate.of(2000, 06, 10));
		user.setGender(Gender.MALE);
		user.setJobStatus(JobStatus.EMPLOYED);
		user.setJobTitle("Engineer");
		user.setSalary(35000);
		user.setResidenceArea(ResidenceArea.URBAN);
		user.setMaritalStatus(MaritalStatus.UNMARRIED);
		
//		UserProfileDto persistedUser = dao.addOrUpdateUser(user);
//		assertNotNull(persistedUser);
	}

}
