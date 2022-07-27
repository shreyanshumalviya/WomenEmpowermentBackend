package com.lti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.lti.dao.NgoDao;

@SpringBootApplication
@ComponentScan(basePackages="com.lti")
@EntityScan(value="com.lti.entity")
public class WomenEmpowermentBackendApplication {

	
	public static void main(String[] args) {
	
		SpringApplication.run(WomenEmpowermentBackendApplication.class, args);
	}

}
